package net.gg.goldandgoodies.encounter

sealed class StatusEffect {

    data class Hitpoints(val hp: Int) : StatusEffect()
    data class Attack(val attack: Int) : StatusEffect()
    data class Armor(val armor: Int) : StatusEffect()
    data class Speed(val speed: Int) : StatusEffect()
    data class Damage(val damage: Int): StatusEffect()
}