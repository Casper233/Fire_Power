execute if block ~ ~-1 ~ #fire_portals:frame/fire_power_dimension if block ~ ~-1 ~1 #fire_portals:frame/fire_power_dimension if block ~ ~ ~-1 #fire_portals:frame/fire_power_dimension if block ~ ~ ~2 #fire_portals:frame/fire_power_dimension if block ~ ~1 ~-1 #fire_portals:frame/fire_power_dimension if block ~ ~1 ~2 #fire_portals:frame/fire_power_dimension if block ~ ~2 ~-1 #fire_portals:frame/fire_power_dimension if block ~ ~2 ~2 #fire_portals:frame/fire_power_dimension if block ~ ~3 ~ #fire_portals:frame/fire_power_dimension if block ~ ~3 ~1 #fire_portals:frame/fire_power_dimension if block ~ ~ ~1 #fire_portals:portal/fire_power_dimension if block ~ ~1 ~ #fire_portals:portal/fire_power_dimension if block ~ ~1 ~1 #fire_portals:portal/fire_power_dimension if block ~ ~2 ~ #fire_portals:portal/fire_power_dimension if block ~ ~2 ~1 #fire_portals:portal/fire_power_dimension run tag @s add unbroken

# If it was, kill all the portal block armor stands (OPTIONAL if you didn't add these in the create file)
execute as @s[tag=!unbroken] positioned ~ ~ ~ run kill @e[distance=..0.5,type=armor_stand,tag=wabportals_aether_portal_stand]
execute as @s[tag=!unbroken] positioned ~ ~1 ~ run kill @e[distance=..0.5,type=armor_stand,tag=wabportals_aether_portal_stand]
execute as @s[tag=!unbroken] positioned ~ ~2 ~ run kill @e[distance=..0.5,type=armor_stand,tag=wabportals_aether_portal_stand]
execute as @s[tag=!unbroken] positioned ~ ~ ~1 run kill @e[distance=..0.5,type=armor_stand,tag=wabportals_aether_portal_stand]
execute as @s[tag=!unbroken] positioned ~ ~1 ~1 run kill @e[distance=..0.5,type=armor_stand,tag=wabportals_aether_portal_stand]
execute as @s[tag=!unbroken] positioned ~ ~2 ~1 run kill @e[distance=..0.5,type=armor_stand,tag=wabportals_aether_portal_stand]

# If it was, destroy all the portal blocks (OPTIONAL if you just used air)
execute as @s[tag=!unbroken] run fill ~ ~ ~ ~ ~2 ~1 air replace #fire_portals:portal/fire_power_dimension

# If it was, play a portal breaking sound (OPTIONAL)
execute as @s[tag=!unbroken] positioned ~ ~ ~ run playsound minecraft:block.glass.break master @a ~ ~ ~ 15 1
execute as @s[tag=!unbroken] positioned ~ ~1 ~ run playsound minecraft:block.glass.break master @a ~ ~ ~ 15 1
execute as @s[tag=!unbroken] positioned ~ ~2 ~ run playsound minecraft:block.glass.break master @a ~ ~ ~ 15 1
execute as @s[tag=!unbroken] positioned ~ ~ ~1 run playsound minecraft:block.glass.break master @a ~ ~ ~ 15 1
execute as @s[tag=!unbroken] positioned ~ ~1 ~1 run playsound minecraft:block.glass.break master @a ~ ~ ~ 15 1
execute as @s[tag=!unbroken] positioned ~ ~2 ~1 run playsound minecraft:block.glass.break master @a ~ ~ ~ 15 1

# If it was, kill the marker to fully delete the portal
execute as @s[tag=!unbroken] run kill @s

# If it wasn't broken, remove the unbroken tag so that it can be checked again
execute as @s[tag=unbroken] run tag @s remove unbroken
