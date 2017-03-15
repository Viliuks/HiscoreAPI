# Hiscores
This Hiscore api utilizes [JSON](https://github.com/stleary/JSON-java) to parse the hiscores.
## Usage
`HiscorePlayer player = new HiscorePlayer(username);`
`player.getSkillLevel(Skill.OVERALL);`

### or

`new HiscorePlayer(username).getSkillLevel(Skill.ATTACK);`
#### Make sure you are using `smpl.api.hiscores.Skill class` rather than OSBots.
## Skills
Every skill is supported.
