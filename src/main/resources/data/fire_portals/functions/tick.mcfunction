scoreboard players set @a player_reach_range 13

execute as @a[scores={fire_power_dimension_portal_activation_check=1..},predicate=fire_portals:dimensions/overworld] at @s rotated as @s anchored eyes run function fire_portals:activate/locate_block/fire_power_dimension
execute as @a[scores={fire_power_dimension_portal_activation_check=1..},predicate=fire_portals:dimensions/fire_power_dimension] at @s rotated as @s anchored eyes run function fire_portals:activate/locate_block/fire_power_dimension

scoreboard players set @a fire_power_dimension_portal_activation_check 0

function re8portals:run/main/fire_power_dimension

execute as @e[predicate=fire_portals:travellers/all_mobs] unless score @s fire_portals_cooldown = @s fire_portals_cooldown run scoreboard players set @s fire_portals_cooldown 0
execute as @e[predicate=fire_portals:travellers/all_mobs,scores={fire_portals_cooldown=1..}] unless entity @e[type=armor_stand,tag=fire_portals_portal_stand,distance=...5] run scoreboard players remove @s fire_portals_cooldown 1
