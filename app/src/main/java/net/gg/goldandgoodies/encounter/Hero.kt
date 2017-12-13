package net.gg.goldandgoodies.encounter

data class Hero(
        val type: HeroType,
        val hitpoints: Int,
        val attack: Int,
        val armor: Int,
        val speed: Int,
        val statusEffects: List<StatusEffect>) {

    fun addStatusEffects(statusEffects: List<StatusEffect>): Hero {
        return this.copy(statusEffects = this.statusEffects + statusEffects)
    }

    enum class HeroType {
        ORC_WARRIOR, ELVEN_BOWMAN, HUMAN_WEAPONMASTER, DWARVEN_AXEBEARER
    }
}