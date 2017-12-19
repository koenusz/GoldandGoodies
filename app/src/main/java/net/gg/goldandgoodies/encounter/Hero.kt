package net.gg.goldandgoodies.encounter


data class Hero(
        val type: HeroType,
        val fullHitpoints: Int,
        val attack: Int,
        val armor: Int,
        val speed: Int,
        val statusEffects: List<StatusEffect>) {


    enum class HeroType {
        ORC_WARRIOR, ELVEN_BOWMAN, HUMAN_WEAPONMASTER, DWARVEN_AXEBEARER
    }
}

fun takeDamage(hero: Hero, damage: Int): Hero {
    return addStatusEffects(hero, listOf(StatusEffect.Damage(damage)))
}

fun addStatusEffects(hero: Hero, statusEffects: List<StatusEffect>): Hero {
    return hero.copy(statusEffects = hero.statusEffects + statusEffects)
}

fun currentHitPoints(hero: Hero): Int {
    var currentHP = hero.fullHitpoints
    val adjustment = hero.statusEffects
            .map {
                when (it) {
                    is StatusEffect.Damage -> - it.damage
                    else -> {
                        0
                    }
                }
            }
            .sum()
    return currentHP + adjustment
}

fun isDead(hero: Hero): Boolean {
    return currentHitPoints(hero) < 1

}
