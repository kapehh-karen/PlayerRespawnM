PlayerRespawnM
==============

Плагин дает возможность управлять респауном игроков.

<b>Конфиг:</b>
<pre># #
# PlayerRespawnM.respawn.NAME: WORLD
# #
# Example:
#   main: world
# Permission:
#   PlayerRespawnM.respawn.main
# #

# Следующие 2 строки для примера
redteam: world_red # игроки с правами PlayerRespawnM.respawn.redteam будут воскресать в мире world_red
blueteam: world_blue # игроки с правами PlayerRespawnM.respawn.blueteam будут воскресать в мире world_blue</pre>

<b>Права:</b>
<code>PlayerRespawnM.respawn.[NAME]</code> - добавляя игроку эти права,
прописывая вместо NAME название своего респауна, игрок будет респауниться только в заданном в конфиге мире.
Например, <code>PlayerRespawnM.respawn.redteam</code> или <code>PlayerRespawnM.respawn.blueteam</code>

<b>Требуется:</b> PluginManager, Vault
