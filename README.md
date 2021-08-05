# Experience Beacons
[https://xp.fracturedcode.net](https://xp.fracturedcode.net)

*Now with server support and configurable beacon reach*

A Fabric Carpet extension for experience-based amplitude on beacon status effects and configurable beacon reach.

## But what does that mean, exactly?
In this mod, the status effect amplitude of beacons is directly (linearly) related to your xp level. For example, after placing down a beacon. you could be at xp level 0 and have resistance 1, or you could be at xp level 700 and have resistance 3. These behaviors are highly configurable *(see **How do I use it?** section)*.

Tying the strength of beacon effects to xp is a way to justify increasing those effects; there's a cost to them. Here's an example scenario. At default settings, if you are at 8000 xp levels and select resistance in your beacon, you will have resistance 4 (or amplitude 3). With this you can survive a 100m fall with no armor at half heart. A 200m fall with armor can be survived easily.

There's a new, separate mechanic that helps balance this out even further that can be changed on a per-effect basis. Xp points can be slowly consumed while using beacons.

The reach of the beacon, or half the side length that makes up the square of a beacon's useful area, can also be changed depending on the beacon pyramid level. I like to use the misnomer "radius" for this value.

To use this mod, you must have [fabric-carpet](https://www.curseforge.com/minecraft/mc-mods/carpet). It is a Carpet extension and Carpet commands are used to configure this mod.

## Who is this for?
This is for late game survival players who are looking for a higher progression and in-game convenience. The more experience you collect, the more op you become.

If you have the means to acquire thousands of levels and would appreciate things like faster speed, higher resistance, strength, regen, jump boost and haste in a vanilla-like package this mod is for you.

I assume if you have the means to acquire that many levels you have something like an enderdragon farm, which indicates you probably have carpet mod anyway. And if you don't, why not? Though, of course, if you don't have a massive xp farm you can decrease the scale to whatever goal you would like. I would recommend [Fat Experience Orbs](https://www.curseforge.com/minecraft/mc-mods/fat-experience-orbs) for increased xp farm throughput if you plan to use the xp drain feature.

### I Am Looking for Feedback
If you are a late game player I would love your feedback on the balance of the features, any changes you would make, or any bugs you find.

For example, what do you think about xp drain? Are the default values too aggressive? Did you just end up turning it off or turning it down?

![beacons in action](https://i.imgur.com/H4sapLl.png)

## How to use the mod and how it works:

Set up a beacon the way you normally would. To access the higher level effects, just keep gaining xp.

- By default, the status effects max out at 8000 xp levels (the xp ceiling). You can change this on a per-effect basis.
- Each status effect has an amplitude ceiling (ie `strength_amplitude_ceiling`) that is reached at the xp ceiling.
- Your xp level and effect amplitude are directly related, if you are at half the `[effect]_xp_ceiling`, your status effect amplitude will be half of `[effect]_amplitude_ceiling` (rounded down).
- Regen is also available.
- A new feature called "xp drain" allows the consumption of xp points within the radius of a beacon. It is proportional to the effect amplitude by `xp points drained = amplitude * [effect]_xp_drain_rate` and can be toggled off.
- You can also affect the beacon "range", "reach", or "radius" with commands.

### How to configure the mod:
- To turn on the mod which is off by default, use **`/carpet xpbeacons true`**
- All configuration settings are in the **`/xpbeacons`** command.
- To toggle off the xp amplitude feature on a specific effect, use **`/xpbeacons [effect]_xp_based_amplitude false`**
- To adjust the xp ceiling for a specific status effect use **`/xpbeacons [effect]_xp_ceiling`**. Default 8000. "Xp ceiling" is kind of a misnomer because you can still go beyond the ceiling, but it doesn't change the status effects to go higher.
- To adjust the effect multiplier there are many variables in the **`/xpbeacons`** command for that purpose suffixed with `amplitude_ceiling` ie `haste_amplitude_ceiling`. These are important as I have tried to give a reasonable balance to them, but you may find your own sweet spot. These values can be set from 0 to 255 and indicate the minecraft effect amplitude. So if you want to have speed 255 at or above your xp ceiling (use and abuse I guess), set the amplitude ceiling to a monstrous 255.
- The xp drain feature is independent of the xp amplitude feature. To toggle off xp drain on a specific effect, use **`/xpbeacons [effect]_xp_drain false`**
- The xp drain rate can be adjusted with **`/xpbeacons [effect]_xp_drain_rate [points per effect amplitude]`**, where the default is `10`.
- To set custom values for beacon range, use **`/xpbeacons beacon_radius_level_[one-four] [range in blocks]`**
- To turn on custom beacon range which is off by default, use **`/xpbeacons beacon_radius_modified true`**

An example of something you might want to change is the speeds you can achieve. If your xp levels are greater than or equal to your xp ceiling value, you will have speed 6, which might be uncomfortable for some people. To adjust it to speed 5, use **`/xpbeacons speed_amplifier_ceiling 4`**.

Maybe you feel your xp is consumed too quickly when in range of a beacon, but you still like the feature. You can turn down the drain rate for a specific effect, say haste, with **`/xpbeacons haste_xp_drain_rate .02`**. Where .02 is a decimal of your choice, though .02 is a good place to start, imo.

A final example is beacon range feels lackluster. You can increase a four level pyramid beacon's range to 100 blocks with **`/xpbeacons beacon_radius_level_four 100`**. Don't forget to toggle this feature on with `beacon_radius_modified` rule.

## What versions will it work with?
Currently, you must have 1.17.x

Version 2.0 is 1.16 compatible, but I wouldn't recommend it. If you would like me to backport this to no older than 1.14, just open a github issue, contact me, or leave a comment on the curseforge page. All you have to do is ask. 

## Why did you make it?
I needed some experience creating carpet extensions, and I had an easy idea to implement that I actually wanted in my game.

Once I get far enough into the game, I prefer not to have to worry too much about dying or be annoyed about how slow tasks can be. The ceiling for these things is too low in vanilla. Beacons are great because this is the role they were supposed to fill, but I find them lacking in effect strength, so I created this mod.

## There are bugs! UNACCEPTABLE
[Submit an issue](https://urlsl.me/xpBeaconsIssues) on the github page.

## Can I have [insert feature here]...
### ...for this mod?
Sure, I will consider it if you put a suggestion in the comments of the CurseForge page or send an email.

Alternatively, you can submit a PR on the GitHub page.

### ...that is unrelated to this project?
My time is valuable. If I like the idea, maybe I will implement it, and do with the mod as I see fit (probably release it for free). Otherwise, you can hire me.

## Future features (coming *actually* soon)
- README updates for better command documentation
- Custom beacon effect duration

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