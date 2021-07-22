
# Experience Beacons
[https://xp.fracturedcode.net](https://xp.fracturedcode.net)

*Now with server support*

A Fabric Carpet extension for experience-based amplitude on beacon status effects.

## But what does that mean, exactly?
In this mod, the status effect amplitude of beacons is directly (linearly) related to your xp level. For example, after placing down a beacon. you could be at xp level 0 and have resistance 1, or you could be at xp level 700 and have resistance 3. These behaviors are highly configurable *(see **How do I use it?** section)*.

Tying the strength of beacon effects to xp is a way to justify increasing those effects; there's a cost to them.

Here's an example scenario. At default settings, if you are at 8000 xp levels and select resistance in your beacon, you will have resistance 4 (or amplitude 3). With this you can survive a 100m fall with no armor at half heart. A 200m fall with armor can be survived easily.

In newer versions, the beacon radius is no longer affected. This is soon to be changed (like, this week). Rest assured this behavior will also be configurable.

To use this mod, you must have [fabric-carpet](https://www.curseforge.com/minecraft/mc-mods/carpet). It is a Carpet extension and Carpet commands are used to configure this mod.

## Who is this for?
This is for late game survival players who are looking for a higher progression and in-game convenience. The more experience you collect, the more op you become.

If you have the means to acquire thousands of levels and would appreciate things like faster speed, higher resistance, strength, regen, jump boost and haste in a vanilla-like package this mod is for you.

I assume if you have the means to acquire that many levels you have something like an enderdragon farm, which indicates you probably have carpet mod anyway. And if you don't, why not? Though, of course, if you don't have a massive xp farm you can decrease the scale to whatever goal you would like.

## How to use the mod and how it works:

Set up a beacon the way you normally would. To access the higher level effects, just keep gaining xp.

- By default, the status effects max out at 8000 xp levels (the xp ceiling). You can change this on a per-effect basis.
- Each status effect has an amplitude ceiling (ie `strength_amplitude_ceiling`) that is reached at the xp ceiling.
- Your xp level and effect amplitude are directly related, if you are at half the `<effect>_xp_ceiling`, your status effect amplitude will be half of `<effect>_amplitude_ceiling` (rounded down).
- Regen is also available.

### How to configure the mod:
- To turn on the feature which is off by default, use **`/carpet xpbeacons true`**
- All configuration settings are in the **`/xpbeacons`** command. 
- To adjust the xp ceiling for a specific status effect use **`/xpbeacons <effect>_xp_ceiling`**. Default 8000. "Xp ceiling" is kind of a misnomer because you can still go beyond the ceiling, but it doesn't change the status effects to go higher.
- To adjust the effect multiplier there are many variables in the **`/xpbeacons`** command for that purpose suffixed with `amplitude_ceiling` ie `haste_amplitude_ceiling`. These are important as I have tried to give a reasonable balance to them, but you may find your own sweet spot. These values can be set from 0 to 255 and indicate the minecraft effect amplitude. So if you want to have speed 255 at or above your xp ceiling (use and abuse I guess), set the amplitude ceiling to a monstrous 255.

An example of something you might want to change is the speeds you can achieve. If your xp levels are greater than or equal to your xp ceiling value, you will have speed 6, which might be uncomfortable for some people. To adjust it to speed 5, use **`/xpbeacons speed_amplifier_ceiling 4`**.

## What versions will it work with?
Currently, you must have 1.17.x

Version 2.0 is 1.16 compatible, but I wouldn't recommend it. If you would like me to backport this to no older than 1.14, just open a github issue, contact me, or leave a comment on the curseforge page. All you have to do is ask. 

## Why did you make it?
I needed some experience creating carpet extensions, and I had an easy idea to implement that I actually wanted in my game.

Once I get far enough into the game, I prefer not to have to worry too much about dying or be annoyed about how slow tasks can be. The ceiling for these things is too low in vanilla. Beacons are great because this is the role they were supposed to fill, but I find them lacking in effect strength, so I created this mod.

## There are bugs! UNACCEPTABLE
[Submit an issue](https://urlsl.me/xpBeaconsIssues) on the github page.

## Can I have < insert feature here >...
### ...for this mod?
Sure, I will consider it if you put a suggestion in the comments of the CurseForge page or send an email.

Alternatively, you can submit a PR on the GitHub page.

### ...that is unrelated to this project?
My time is valuable. If I like the idea, maybe I will implement it, and do with the mod as I see fit (probably release it for free). Otherwise, you can hire me.

## Future features (coming *actually* soon)
- Configurable beacon radius
- Configurable xp drain when using a beacon
- A new home for the mod on my website (don't worry, I won't be yanking it from curseforge)
- A maven repository for developers
- Fix bug no carpet rule validation for amplitude ceiling

## Dependencies
Minecraft: 1.17.x

Fabric loader: >= 0.11.0

fabric-carpet: 1.4.*

## Links
[CurseForge page (with jar download)](https://xp.fracturedcode.net)

[Source Code](https://urlsl.me/xpBeaconsSource)

[Wiki](https://urlsl.me/xpBeaconsWiki)

[Issue Tracker](https://urlsl.me/xpBeaconsIssues)


## License LGPL v3.0
Previous versions of this project were MIT licensed, now it uses LGPL. You can see a copy of attached in the root directory of the source code.
If you would like to use this code in a context outside what is permitted by this license, contact me preferably by email (found on github).