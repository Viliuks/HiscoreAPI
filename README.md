# Hiscores
This Hiscore api utilizes [JSON](https://github.com/stleary/JSON-java) to parse the hiscores.
##Usage
`HiscorePlayer player = new HiscorePlayer(username);`
`player.getSkillLevel(Skill.OVERALL);`

###or
`new HiscorePlayer(username).getSkillLevel(SKILL.ATTACK);`

##Skills
Every skill is supported.