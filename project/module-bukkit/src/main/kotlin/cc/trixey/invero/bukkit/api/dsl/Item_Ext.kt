package cc.trixey.invero.bukkit.api.dsl

import cc.trixey.invero.bukkit.element.control.ControlPageItem
import cc.trixey.invero.bukkit.element.control.ControlScrollItem
import cc.trixey.invero.common.panel.ElementalPanel
import cc.trixey.invero.common.panel.PagedPanel
import cc.trixey.invero.common.panel.ScrollPanel
import org.bukkit.Material

/**
 * Invero
 * cc.trixey.invero.bukkit.api.dsl.Item_Ext
 *
 * @author Arasple
 * @since 2023/1/11 21:12
 */
inline fun ElementalPanel.pageItem(
    panel: PagedPanel,
    amount: Int = +1,
    slot: Int,
    material: Material,
    block: ControlPageItem.() -> Unit = {}
) {
    ControlPageItem(panel, amount).apply {
        build(material)
        block(this)

        set(scale.convertToPosition(slot))
    }
}

inline fun ElementalPanel.scrollItem(
    panel: ScrollPanel,
    amount: Int = +1,
    slot: Int,
    material: Material,
    block: ControlScrollItem.() -> Unit = {}
) {
    ControlScrollItem(panel, amount).apply {
        build(material)
        block(this)

        set(scale.convertToPosition(slot))
    }
}
