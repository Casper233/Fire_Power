execute if block ~ ~ ~ #fire_portals:activation/fire_power_dimension if block ~ ~-1 ~ #fire_portals:frame/fire_power_dimension run function fire_portals:activate/check_frame/fire_power_dimension/bottom
execute if block ~ ~ ~ #fire_portals:activation/fire_power_dimension if block ~ ~-2 ~ #fire_portals:frame/fire_power_dimension run function fire_portals:activate/check_frame/fire_power_dimension/mid
execute if block ~ ~ ~ #fire_portals:activation/fire_power_dimension if block ~ ~-3 ~ #fire_portals:frame/fire_power_dimension run function fire_portals:activate/check_frame/fire_power_dimension/top
scoreboard players remove @s player_reach_range 1
execute if score @s player_reach_range matches 1.. if block ~ ~ ~ #fire_portals:air positioned ^ ^ ^0.5 run function fire_portals:activate/locate_block/fire_power_dimension
