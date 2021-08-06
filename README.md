# Experience Beacons
[xp.fracturedcode.net](https://xp.fracturedcode.net)

[Here is the GitHub mirror](https://github.com/FracturedCode/XpBeacons)

*Now with server support*

A Fabric Carpet extension for the ultimate beacon configuration like experience-based amplitude on beacon status effects, configurable beacon reach and more.

![beacons in action](https://i.imgur.com/H4sapLl.png)

## But what does that mean, exactly?
Most aspects of how beacons apply effects can be altered with this mod. The reach, duration and amplitude of each individual effect can be changed. Furthermore, you can increase the maximum pyramid size affecting how the beacon behaves.

There is a unique highlight feature of this mod, the "experience-based amplitude". In this mod, the beacon status effect amplitude is directly (linearly) related to your xp level. For example, after placing down a beacon, you could be at xp level 0 and have resistance 1, or you could be at xp level 700 and have resistance 3. These behaviors are highly configurable.

Tying the strength of beacon effects to xp is a way to justify increasing those effects; there's a cost to them. Here's another example scenario. At default settings, if you are at 8000 xp levels and select resistance in your beacon, you will have resistance (amplitude) 4. With this you can survive a 100m fall with no armor at half heart. A 200m fall with armor can be survived easily.

There's a new, separate mechanic that helps balance this out even further that can be changed on a per-effect basis. Xp points can be slowly consumed while using beacons, as an ongoing cost to use beacons.

You can configure the duration of effects.

The "reach" of the beacon, or half the side length that makes up the square of a beacon's useful area, can also be changed depending on the beacon pyramid level. I like to use the misnomer "radius" for this value sometimes.

![https://i.imgur.com/1M3sWAj.png](https://i.imgur.com/1M3sWAj.png)

## Who is this for?
This is for late game survival players who are looking for a higher progression and in-game convenience. The more experience you collect, the more op you become.

If you have the means to acquire thousands of levels and would appreciate things like faster speed, higher resistance, strength, regen, jump boost and haste in a vanilla-like package this mod is for you.

I assume if you have the means to acquire that many levels you have something like an enderdragon farm, which indicates you probably have carpet mod anyway. And if you don't, why not? Though, of course, if you don't have a massive xp farm you can decrease the scale to whatever goal you would like. I would recommend the `CombineXPOrbs` carpet rule if you choose to turn on the xp drain feature to increase the throughput of your xp farms.

### I Am Looking for Feedback
If you are a late game player I would love your feedback on the balance of the features, any changes you would make, or any bugs you find.

For example, what do you think about xp drain? Are the default values too aggressive? Did you just end up turning it off or turning it down?

## How to use the mod
[Please reference the wiki](https://urlsl.me/xpBeaconsWiki). It includes every available command.

Contact me for direct support.

## Why did you make it?
I needed some experience creating carpet extensions, and I had an easy idea to implement that I actually wanted in my game.

Once I get far enough into the game, I prefer not to have to worry too much about dying or be annoyed about how slow tasks can be. The ceiling for these things is too low in vanilla. Beacons are great because this is the role they were supposed to fill, but I find them lacking in effect strength, so I created this mod.

## There are bugs?! UNACCEPTABLE
[Submit an issue](https://urlsl.me/xpBeaconsIssues) on the gitea or github pages.

## Future features
I have none planned. In my eyes, this is now a rare "complete" project. Obviously, I will have to come back to maintain it for future versions, but it currently has all the features I want. If you have suggestions submit an issue, pull request, leave a comment or contact me directly.

## What versions will it work with?
Currently, you must have 1.17.x

Version 2.0 is 1.16 compatible, but I wouldn't recommend it. If you would like me to backport this to no older than 1.14, just open a github issue, contact me, or leave a comment. All you have to do is ask.

## Dependencies
Minecraft: 1.17.x

Fabric loader: >= 0.11.0

fabric-carpet: 1.4.*

To use this mod, you must have [fabric-carpet](https://www.curseforge.com/minecraft/mc-mods/carpet). It is a Carpet extension and Carpet commands are used to configure this mod.

The default behavior out of the box is vanilla; you can play with the dials to customize your experience.

## Links
[Project Home with source code](https://xp.fracturedcode.net)

[GitHub source code mirror](https://urlsl.me/xpBeaconsSource)

[Binaries (maven repository)](https://maven.fracturedcode.net/releases/net/fracturedcode/xpbeacons)

[Wiki](https://urlsl.me/xpBeaconsWiki)

[Issue Tracker](https://urlsl.me/xpBeaconsIssues)

## Can I have [insert feature here]...
### ...for this mod?
Sure, I will consider it if you contact me.

Alternatively, you can submit a PR on the GitHub page.

### ...that is unrelated to this project?
My time is valuable. If I like the idea, maybe I will implement it, and do with the mod as I see fit (probably release it for free). Otherwise, you can hire me.

## License LGPL v3.0
Previous versions of this project were MIT licensed, now it uses LGPL. You can see a copy of attached in the root directory of the source code.
If you would like to use this code in a context outside what is permitted by this license, contact me.