   ![Logo](https://www.spigotmc.org/data/resource_icons/109/109643.jpg)
## ShowDamage 
### What does this do?
This is a simple (yet configurable) plugin that allows to see the damage done to any entity. This is how it looks:

Non critical damage dealt by an entity:

![non-critical-damage](https://media.discordapp.net/attachments/877237543819702322/1108856891003654214/xp6yfP3.png)

Critical damage dealt by an entity has an indicator:

![critical-damage](https://media.discordapp.net/attachments/877237543819702322/1108856891490185306/DGsQ6me.png)

Damage dealt to entity plus sweep attack to other entity (can be disabled in config):

![sweep-attack](https://media.discordapp.net/attachments/877237543819702322/1108856891251114014/lm7aGQr.png)

Damage dealt to entity with an explosion by block (or entity):

![explosion-attack-gif](https://cdn.discordapp.com/attachments/877237543819702322/1108858979628613673/13WrEhT.gif)

The plugin also has a message output if damage was caused by a projectile:

![projectile-message](https://media.discordapp.net/attachments/918548823134077058/1108231482075517058/image.png)

### Feature list
- Highly configurable config
   -  Popup lifetime adjustable
   -  Projectile Chat messages toggleable
   -  Multiple Entity damage stacking toggleable & adjustable
   -  Popup visiblity through walls toggleable
   -  Hex Color-coded messages adjustable
   -  Plugin functionality toggleable
- Config hot-reloadable
- Multiple entity damage stacks into one message
- Chat messages for projectile damage
- Gradient text for popups
### Commands
- /disablepopup (alias: dpu)
### Roadmap (18/05/23)
- [X] Add Text Displays
- [X] Add Multi Entity damage
- [X] Add text visiblity through walls
- [X] Add more configurability (pop-up lifetime, config use in new features)
- [ ] Animated text displays for MC 1.20 (requires bug fix in the release)
- [X] Add hearts option
- [ ] Add alternate visible to all option where only PVP is affected and PVE is still visible to other players.
- [X] Add command to disable pop-ups for the executor only
- [ ] Add an option that switches the received damage in hp to the remaining (Zombie took 6 HP damage / Zombie have 14 HP left) + heart form
- [ ] Add action bar features

### Config
```yaml
# * does not work in legacy mode
messages:
  damage-visible: true                    # Toggles damage popup visiblity.
  damage-projectile-chat-messages: true   # Toggles projectile chat messages being sent to player shooter.
  popup-background-transparency: 64       # Determines the transparency of the popup.*
  action-bar-messages: true               # Toggles whether the action bar should be used for displaying remaining health.
  
damage:
  legacy-mode: false                      # Toggles whether ArmorStands should be used instead of TextDisplays
  visible-to-all: "off"                   # (off/pve/all) determines whether players should not see each others popups, see each others popups on entities excluding players, or should see every popup including players.
  show-through-walls: true                # Toggles whether popups should be visible through blocks and entities.*
  popup-lifetime: 25.0                    # Determines how long a popup should stay alive for. 20 ticks ~> 1 second
  allow-players-to-disable: true          # Toggles whether players can disable the popup, overrides visble-to-all individually
  hide-entity-radius: 32                  # Hides popups to players who are within a (x) radius and have disabled popups for themselves
  
multiple-entity-count:
  enabled: true                           # Toggles whether damage dealt to multiple entities should stacked and displayed in one popup
  distance: 10.0                          # Determines size of radius to consider what damage is related.
  
colors:
  crit-damage:
    first: "BE2510"                       # First HEX color of crit-damage pop-up gradient
    second: "FD7348"                      # Second HEX color of crit-damage pop-up gradient
  crit-sign:
    sign: "x"                             # Special sign showing that the damage was critical: ✧, https://forum.maestrea.com/threads/minecraft-symbols-emoticons-and-characters.11264/
  default-damage:
    first: "F16666"                       # First HEX color of non-crit-damage pop-up gradient
    second: "B79191"                      # Second HEX color of non-crit-damage pop-up gradient
  accent:
    first: "25af46"                       # Main projectile-damage message color. Dark green by default
    second: "c3c3c3"                      # Entity name, damage and HP values color
    third: "2a4858"                       # Color of "i" inside square brackets
```


### Releases
Check releases for the latest jar files, this plugin gets updated often as of 18/05/2023.
You can build the jar file if you would like, as releases might not contain the latest fixes and features, however expect them to be more buggy than an official release. 

### Other
If you notice any bugs or errors in plugin, please file an issue in this repo or contact us via Discord: xw1w1# 0001 & Maik# 0711

All source code is available for free.
