package com.main.phc.inside

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import kotlin.random.Random

data class Member(
    val image: Painter,
    val name: String,
    val price: String,
    var id: String = "",
    var producer: String = "",
    var producerCountry: String = "",
    var count: Int = 1,
    var icon: ImageVector = Icons.Default.FavoriteBorder,
    var isSelected: Boolean = false,
)
{

    companion object {
        private val generatedIds = mutableSetOf<String>()
        private fun generateUniqueId(length: Int): String {
            val charPool: List<Char> = ('A'..'Z') + ('a'..'z') + ('0'..'9')
            var uniqueId: String
            do {
                uniqueId = (1..length)
                    .map { Random.nextInt(0, charPool.size) }
                    .map(charPool::get)
                    .joinToString("")
            } while (generatedIds.contains(uniqueId))
            generatedIds.add(uniqueId)
            return uniqueId
        }
    }

    private val unID = generateUniqueId(8)

    init {
        this.id = unID
    }

}