package cc.trixey.invero.core.compat.item

import cc.trixey.invero.common.supplier.ItemSourceProvider
import cc.trixey.invero.core.compat.DefItemProvider
import cc.trixey.invero.core.serialize.ItemStackJsonSerializer
import cc.trixey.invero.core.util.standardJson
import org.bukkit.inventory.ItemStack
import taboolib.platform.util.deserializeToItemStack
import java.util.concurrent.ConcurrentHashMap

/**
 * Invero
 * cc.trixey.invero.core.compat.item.SerializedItemProvider
 *
 * @author Arasple
 * @since 2023/1/29 15:45
 */
@DefItemProvider(["base64", "json", "serialized"])
class SerializedItemProvider : ItemSourceProvider {

    companion object {

        private val cache = ConcurrentHashMap<String, ItemStack>()

    }

    override fun getItem(identifier: String, context: Any?): ItemStack {
        return cache.computeIfAbsent(identifier) {
            if (identifier.startsWith("{"))
                standardJson.decodeFromString(ItemStackJsonSerializer, identifier)
            else identifier.toByteArray().deserializeToItemStack()
        }
    }

}