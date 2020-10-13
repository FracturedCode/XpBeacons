
# Experience Beacons
[https://xp.urlsl.me](xp.urlsl.me)

A Fabric Carpet extension for experience-based amplitude on beacon status effects.

## But what does that mean, exactly?
In this mod, the status effect strength of beacons is directly correlated with your xp level (and adjusted by some factor). For example, after placing down a beacon. you could be at xp level 0 and have resistance 1, or you could be at xp level 700 and have resistance 3. These behaviors are highly configurable *(see **How do I use it?** section)*.

Tying the strength of beacon effects to xp is a way to justify increasing those effects; there's a cost to them.

To use this mod, you must have [fabric-carpet](https://www.curseforge.com/minecraft/mc-mods/carpet). It is a Carpet extension and Carpet commands are used to configure this mod.

## Who is this for?
This is for late game survival players who are looking for a higher progression and in-game convenience. The more experience you collect, the more op you become.

If you have the means to acquire thousands of levels and would appreciate things like faster speed, higher resistance and better strength (and don't forget haste) in a vanilla-like package this mod is for you.

I assume if you have the means to acquire that many levels you have something like an enderdragon farm which indicates you probably have carpet mod anyway. And if you don't, why not? Though, of course, if you don't have a massive xp farm you can decrease the scale to whatever goal you would like.

## How do I use it? (and small details about how it works)

Set up a beacon the way you normally would. To access the higher level effects, just keep gaining experience.

- By default the status effects max out at 8000 levels (the xp ceiling).
- The effects will be halved unless you select the secondary effect. 
- Regen is also available. The effect is not halved in this case. Selecting regen as a secondary over another effect means that other effect will be halved; same rules as vanilla. Place down another beacon and select that effect as secondary for full power.

### Here's some settings:
- To turn on the feature which is on by default, use **`/carpet xpBeacons true`**
- To adjust the xp ceiling use **`/xpBeaconsSettings xpBeaconsMax <some int>`**. Default 8000. "Xp ceiling" is kind of a misnomer because you can still go beyond the ceiling, but it doesn't change the status effects to go higher.
- To adjust the effect multiplier there are many variables in the **`/xpBeaconsSettings`** command for that purpose suffixed with `Multiplier` ie `hasteMultiplier`. These are important as I have tried to give a reasonable balance to them, but you may find your own sweet spot. These values can be set from 0 to 1.0 and are a proportion of 255. So if you want to have speed 255 at or above your xp ceiling (use and abuse I guess), set the proportion to a monstrous 1.0.

An example of something you might want to change is the speeds you can achieve. If your xp levels are greater than or equal to your xpBeaconsMax value, you will have speed 10, which might be uncomfortable for some people. To adjust it to speed 5, find out what percent 5 is of 255 (5/255=.02). Then use **`/xpBeaconsSettings speedMultiplier .02`**.

## What versions will it work with?
Currently, you must have 1.16.x

## Why did you make it?
I needed some experience about creating carpet extensions, and I had an easy idea to implement that I actually wanted in my game.

Once I get far enough into the game, I prefer not to have to worry too much about dying or be annoyed about how slow tasks can be. The ceiling for these things is too low in vanilla. Beacons are great because this is the role they were supposed to fill, but I find them lacking in effect strength, so I created this mod.

## Can I have < insert feature here >?
Sure, I will consider it if you put a suggestion in the comments of the CurseForge page or send an email.

## Dependencies
Minecraft: 1.16.x

Fabric loader: >= 0.9.0

Carpet: *? Probably anything made for 1.16

## Links
[CurseForge page (with jar download)](xp.urlsl.me)

[Source Code](urlsl.me/xpBeaconsSource)

[Wiki](urlsl.me/xpBeaconsWiki)

[Issue Tracker](urlsl.me/xpBeaconsIssues)

## License MIT
