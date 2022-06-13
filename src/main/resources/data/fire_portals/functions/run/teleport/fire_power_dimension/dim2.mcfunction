execute in minecraft:overworld run teleport @s ~ ~ ~
scoreboard players set @s fire_portals_cooldown 300
execute in fire_power:fire_power_dimension run forceload remove ~5 ~5 ~-5 ~-5
execute in minecraft:overworld run forceload remove ~5 ~5 ~-5 ~-5
