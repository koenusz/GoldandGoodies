package net.gg.goldandgoodies.encounter

data class NPC(
        val type: NPCType,
        val hitpoints: Int,
        val attack: Int,
        val armor: Int,
        val speed: Int,
        val statusEffects: List<StatusEffect>) {

    fun addStatusEffects(statusEffects: List<StatusEffect>): NPC {
        return this.copy(statusEffects = this.statusEffects + statusEffects)
    }

    enum class NPCType {
        GOBLIN, OGRE
    }
}