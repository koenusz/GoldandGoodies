package net.gg.goldandgoodies

import net.gg.goldandgoodies.encounter.Hero
import net.gg.goldandgoodies.encounter.StatusEffect
import org.junit.Assert
import org.junit.Test

class HeroPartyDataTest {

    @Test
    fun adding_statuseffect() {
        var hero = Hero(Hero.HeroType.ORC_WARRIOR, 1, 1, 1, 1, listOf(StatusEffect.Hitpoints(1)))
        Assert.assertEquals(1, hero.statusEffects.size)
        hero = hero.addStatusEffects(listOf(StatusEffect.Damage(-1)))
        print(hero)
        Assert.assertEquals(2, hero.statusEffects.size)
    }
}