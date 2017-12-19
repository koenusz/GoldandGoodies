package net.gg.goldandgoodies.encounter

import org.junit.Assert
import org.junit.Test

class HeroTest {


    val hero = Hero(Hero.HeroType.DWARVEN_AXEBEARER, 10, 1, 1, 1, listOf())


    @Test
    fun take_damage() {
        val hero = takeDamage(hero, 5)
        Assert.assertEquals(5, currentHitPoints(hero))
    }


    @Test
    fun adding_statuseffect() {
        var hero = Hero(Hero.HeroType.ORC_WARRIOR, 1, 1, 1, 1, listOf(StatusEffect.Hitpoints(1)))
        Assert.assertEquals(1, hero.statusEffects.size)
        hero = addStatusEffects(hero, listOf(StatusEffect.Damage(-1)))
        print(hero)
        Assert.assertEquals(2, hero.statusEffects.size)
    }


    @Test
    fun dead() {
        Assert.assertEquals(false, isDead(hero))
        val damaged = takeDamage(hero, 10)
        Assert.assertEquals(true, isDead(damaged))
    }
}