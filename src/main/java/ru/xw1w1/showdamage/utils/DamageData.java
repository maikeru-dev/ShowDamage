package ru.xw1w1.showdamage.utils;


import net.kyori.adventure.text.Component;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.text.DecimalFormat;

import static ru.xw1w1.showdamage.utils.TextUtils.*;

public class DamageData {
    private final int HEART_VALUE = 2;
    private final double rawDamage;
    private final LivingEntity damager;
    private final boolean critical;
    private final boolean hearts;
    private final LivingEntity damaged;
    private @NotNull Component formattedDamage;
    public DamageData(EntityDamageByEntityEvent event, boolean hearts) {
        this.rawDamage = event.getDamage();
        this.damager = (LivingEntity) event.getDamager();
        this.damaged = (LivingEntity) event.getEntity();
        this.critical = event.isCritical();
        this.hearts = hearts;

        if (hearts) {
            formattedDamage = convertDecimalToHearts(rawDamage);
        }else {
            formattedDamage = component((new DecimalFormat("0.00")).format(rawDamage));
        }

    }
    public DamageData preAppend(String string) {
        formattedDamage = single(component(string), formattedDamage);
        return this;
    }
    public boolean isCritical() {
        return critical;
    }
    public LivingEntity getDamager() {
        return damager;
    }
    public LivingEntity getDamaged() {
        return damaged;
    }
    private Component convertDecimalToHearts(double rawDamage) {
        int smallHearts = Math.floorMod((long) rawDamage, HEART_VALUE);
        int bigHearts = (int) (rawDamage-smallHearts)/2;
        return component("❤"
                .repeat(Math.max(0, bigHearts))
                .concat(
                    "♥".repeat(Math.max(0, smallHearts))
                ));

    }
    public Component valueOf() {
        return formattedDamage;
    }
    public Component getFormattedHealth() {
        if (hearts) {
            return convertDecimalToHearts(damaged.getHealth()-rawDamage);
        }else {
            return component((new DecimalFormat("0.00")).format(damaged.getHealth()-rawDamage));
        }
    }

    /*
    Add hearts option
        - Present amount of damage dealt and health remaining in heart form
        - Use TEXTDISPLAY's Scale function to make text bigger
    Provide a perk option so server owners can monetize this feature?
    Animation for when TextDisplays get updated in MC 1.20
    Write projectile damage in ACTION BAR
     */
}