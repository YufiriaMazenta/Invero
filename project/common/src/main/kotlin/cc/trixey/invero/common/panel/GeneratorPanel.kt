package cc.trixey.invero.common.panel

import cc.trixey.invero.common.Pos

/**
 * Invero
 * cc.trixey.invero.common.panel.GeneratorPanel
 *
 * @author Arasple
 * @since 2023/1/11 15:56
 */
interface GeneratorPanel<T, R> : ElementalPanel {

    var sourceElements: List<T>

    val outputElements: ArrayList<R?>

    var generator: (T) -> R?

    val generatorPool: Set<Pos>

    fun getOutput(index: Int): R? {
        if (outputElements[index] == null) {
            outputElements[index] = generator(sourceElements[index])
        }
        return outputElements[index]
    }

    fun generatorElements(block: () -> List<T>) {
        sourceElements = block()
    }

    fun onGenerate(block: (T) -> R?) {
        generator = block
    }

}