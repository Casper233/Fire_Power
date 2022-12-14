fill ~2 ~-1 ~ ~-1 ~3 ~ fire_power:fire_ingot_block
fill ~ ~ ~ ~1 ~2 ~ minecraft:moving_piston

# Summon armor stands for portal blocks
summon armor_stand ~.5 ~ ~.506 {NoGravity:1b,Silent:1b,Invulnerable:1b,ShowArms:1b,Marker:1b,Invisible:1b,Tags:["wabportals_aether_portal_stand","wabportals_portal_stand"],ArmorItems:[{},{},{},{id:"fire_power:fire_element_block",Count:1b,tag:{CustomModelData:286000}}]}
summon armor_stand ~1.5 ~ ~.506 {NoGravity:1b,Silent:1b,Invulnerable:1b,ShowArms:1b,Marker:1b,Invisible:1b,Tags:["wabportals_aether_portal_stand","wabportals_portal_stand"],ArmorItems:[{},{},{},{id:"fire_power:fire_element_block",Count:1b,tag:{CustomModelData:286000}}]}
summon armor_stand ~.5 ~1 ~.506 {NoGravity:1b,Silent:1b,Invulnerable:1b,ShowArms:1b,Marker:1b,Invisible:1b,Tags:["wabportals_aether_portal_stand","wabportals_portal_stand"],ArmorItems:[{},{},{},{id:"fire_power:fire_element_block",Count:1b,tag:{CustomModelData:286000}}]}
summon armor_stand ~1.5 ~1 ~.506 {NoGravity:1b,Silent:1b,Invulnerable:1b,ShowArms:1b,Marker:1b,Invisible:1b,Tags:["wabportals_aether_portal_stand","wabportals_portal_stand"],ArmorItems:[{},{},{},{id:"fire_power:fire_element_block",Count:1b,tag:{CustomModelData:286000}}]}
summon armor_stand ~.5 ~2 ~.506 {NoGravity:1b,Silent:1b,Invulnerable:1b,ShowArms:1b,Marker:1b,Invisible:1b,Tags:["wabportals_aether_portal_stand","wabportals_portal_stand"],ArmorItems:[{},{},{},{id:"fire_power:fire_element_flower",Count:1b,tag:{CustomModelData:286000}}]}
summon armor_stand ~1.5 ~2 ~.506 {NoGravity:1b,Silent:1b,Invulnerable:1b,ShowArms:1b,Marker:1b,Invisible:1b,Tags:["wabportals_aether_portal_stand","wabportals_portal_stand"],ArmorItems:[{},{},{},{id:"fire_power:fire_element_flower",Count:1b,tag:{CustomModelData:286000}}]}

# Summon the marker to make the portal work
summon marker ~.5 ~ ~.506 {NoGravity:1b,Silent:1b,Invulnerable:1b,Tags:["fire_portals_fire_power_dimension_marker","fire_portals_fire_power_dimension_marker_x"]}

# Play a portal opening sound (OPTIONAL)
playsound minecraft:block.end_portal.spawn master @a ~ ~ ~ 15 1

# Get rid of everything unnecessary
forceload remove ~-10 ~-10 ~10 ~10
