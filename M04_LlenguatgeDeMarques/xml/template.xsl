<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:param name="paramID"/>
    <xsl:template match="/xml">
        <html>
            <head>
                <meta charset="UTF-8"/>
                <title>BATTLE</title>
                <link href="battle.css" rel="stylesheet"/>
                <link rel="preconnect" href="https://fonts.googleapis.com"/>
                <link rel="preconnect" href="https://fonts.gstatic.com"/>
                <link href="https://fonts.googleapis.com/css2?family=Josefin+Sans:ital,wght@0,700;1,600&ampdisplay=swap" rel="stylesheet"/>
                <link rel="website icon" type="png" href="../../M03_Programacio/WarriorsImages/human/huma3.jpg"/>
            </head>
            <body>
                <div class="int">
                    <h1>BATTLE</h1>
                    <h4>HISTORIAL DE BATALLAS</h4>
                </div>
                <div class="bttl">
                    <xsl:call-template name="templateBatalla"/>
                </div>
            </body>
        </html>
    </xsl:template>

    <xsl:template name="templateBatalla">
        <xsl:for-each select="battle">
            <div class="content">
                <h3>BATTLE_ID:</h3>
                <h3><xsl:value-of select="battle_id"/></h3>
                <h3>PLAYER_ID:</h3>
                <h3><xsl:value-of select="player_id"/></h3>
            </div>
            <div class="doble">
                <div class="player">
                    <xsl:if test="warrior_id=1">
                        <p>WARRIOR_ID:</p>
                        <p><xsl:value-of select="warrior_id"/></p>
                        <img src="../../M03_Programacio/WarriorsImages/elf/elf1.jpg"></img>
                        <P>WARRIOR_WEAPON_ID:</P>
                        <p><xsl:value-of select="warrior_weapon_id"/></p>
                        <P>INJURIES_CAUSED</P>
                        <p><xsl:value-of select="injuries_caused"/></p>
                    </xsl:if>
                    <xsl:if test="warrior_id=2">
                        <p>WARRIOR_ID:</p>
                        <p><xsl:value-of select="warrior_id"/></p>
                        <img src="../../M03_Programacio/WarriorsImages/elf/elf2.jpg"></img>
                        <P>WARRIOR_WEAPON_ID:</P>
                        <p><xsl:value-of select="warrior_weapon_id"/></p>
                        <P>INJURIES_CAUSED</P>
                        <p><xsl:value-of select="injuries_caused"/></p>
                    </xsl:if>
                    <xsl:if test="warrior_id=3">
                        <p>WARRIOR_ID:</p>
                        <p><xsl:value-of select="warrior_id"/></p>
                        <img src="../../M03_Programacio/WarriorsImages/elf/elf3.jpg"></img>
                        <P>WARRIOR_WEAPON_ID:</P>
                        <p><xsl:value-of select="warrior_weapon_id"/></p>
                        <P>INJURIES_CAUSED</P>
                        <p><xsl:value-of select="injuries_caused"/></p>
                    </xsl:if>
                    <xsl:if test="warrior_id=4">
                        <p>WARRIOR_ID:</p>
                        <p><xsl:value-of select="warrior_id"/></p>
                        <img src="../../M03_Programacio/WarriorsImages/human/huma1.png"></img>
                        <P>WARRIOR_WEAPON_ID:</P>
                        <p><xsl:value-of select="warrior_weapon_id"/></p>
                        <P>INJURIES_CAUSED</P>
                        <p><xsl:value-of select="injuries_caused"/></p>
                    </xsl:if>
                    <xsl:if test="warrior_id=5">
                        <p>WARRIOR_ID:</p>
                        <p><xsl:value-of select="warrior_id"/></p>
                        <img src="../../M03_Programacio/WarriorsImages/human/huma2.jpg"></img>
                        <P>WARRIOR_WEAPON_ID:</P>
                        <p><xsl:value-of select="warrior_weapon_id"/></p>
                        <P>INJURIES_CAUSED</P>
                        <p><xsl:value-of select="injuries_caused"/></p>
                    </xsl:if>
                    <xsl:if test="warrior_id=6">
                        <p>WARRIOR_ID:</p>
                        <p><xsl:value-of select="warrior_id"/></p>
                        <img src="../../M03_Programacio/WarriorsImages/human/huma3.jpg"></img>
                        <P>WARRIOR_WEAPON_ID:</P>
                        <p><xsl:value-of select="warrior_weapon_id"/></p>
                        <P>INJURIES_CAUSED</P>
                        <p><xsl:value-of select="injuries_caused"/></p>
                    </xsl:if>
                    <xsl:if test="warrior_id=7">
                        <p>WARRIOR_ID:</p>
                        <p><xsl:value-of select="warrior_id"/></p>
                        <img src="../../M03_Programacio/WarriorsImages/dwarf/dwarf1.jpg"></img>
                        <P>WARRIOR_WEAPON_ID:</P>
                        <p><xsl:value-of select="warrior_weapon_id"/></p>
                        <P>INJURIES_CAUSED</P>
                        <p><xsl:value-of select="injuries_caused"/></p>
                    </xsl:if>
                    <xsl:if test="warrior_id=8">
                        <p>WARRIOR_ID:</p>
                        <p><xsl:value-of select="warrior_id"/></p>
                        <img src="../../M03_Programacio/WarriorsImages/dwarf/dwarf2.jpg"></img>
                        <P>WARRIOR_WEAPON_ID:</P>
                        <p><xsl:value-of select="warrior_weapon_id"/></p>
                        <P>INJURIES_CAUSED</P>
                        <p><xsl:value-of select="injuries_caused"/></p>
                    </xsl:if>
                    <xsl:if test="warrior_id=9">
                        <p>WARRIOR_ID:</p>
                        <p><xsl:value-of select="warrior_id"/></p>
                        <img src="../../M03_Programacio/WarriorsImages/dwarf/dwarf3.jpg"></img>
                        <P>WARRIOR_WEAPON_ID:</P>
                        <p><xsl:value-of select="warrior_weapon_id"/></p>
                        <P>INJURIES_CAUSED</P>
                        <p><xsl:value-of select="injuries_caused"/></p>
                    </xsl:if>
                </div>
                <div class="versus">
                    <h1>VS</h1>
                </div>
                <div class="oppon">
                    <xsl:if test="opponent_id=1">
                        <p>OPPONENT_ID:</p>
                        <p><xsl:value-of select="opponent_id"/></p>
                        <img src="../../M03_Programacio/WarriorsImages/elf/elf1.jpg"></img>
                        <P>OPPONENT_WEAPON_ID:</P>
                        <p><xsl:value-of select="opponent_weapon_id"/></p>
                        <P>INJURIES_SUFFERED</P>
                        <p><xsl:value-of select="injuries_suffered"/></p>
                    </xsl:if>
                    <xsl:if test="opponent_id=2">
                        <p>OPPONENT_ID:</p>
                        <p><xsl:value-of select="opponent_id"/></p>
                        <img src="../../M03_Programacio/WarriorsImages/elf/elf2.jpg"></img>
                        <P>OPPONENT_WEAPON_ID:</P>
                        <p><xsl:value-of select="opponent_weapon_id"/></p>
                        <P>INJURIES_SUFFERED</P>
                        <p><xsl:value-of select="injuries_suffered"/></p>
                    </xsl:if>
                    <xsl:if test="opponent_id=3">
                        <p>OPPONENT_ID:</p>
                        <p><xsl:value-of select="opponent_id"/></p>
                        <img src="../../M03_Programacio/WarriorsImages/elf/elf3.jpg"></img>
                        <P>OPPONENT_WEAPON_ID:</P>
                        <p><xsl:value-of select="opponent_weapon_id"/></p>
                        <P>INJURIES_SUFFERED</P>
                        <p><xsl:value-of select="injuries_suffered"/></p>
                    </xsl:if>
                    <xsl:if test="opponent_id=4">
                        <p>OPPONENT_ID:</p>
                        <p><xsl:value-of select="opponent_id"/></p>
                        <img src="../../M03_Programacio/WarriorsImages/human/huma1.png"></img>
                        <P>OPPONENT_WEAPON_ID:</P>
                        <p><xsl:value-of select="opponent_weapon_id"/></p>
                        <P>INJURIES_SUFFERED</P>
                        <p><xsl:value-of select="injuries_suffered"/></p>
                    </xsl:if>
                    <xsl:if test="opponent_id=5">
                        <p>OPPONENT_ID:</p>
                        <p><xsl:value-of select="opponent_id"/></p>
                        <img src="../../M03_Programacio/WarriorsImages/human/huma2.jpg"></img>
                        <P>OPPONENT_WEAPON_ID:</P>
                        <p><xsl:value-of select="opponent_weapon_id"/></p>
                        <P>INJURIES_SUFFERED</P>
                        <p><xsl:value-of select="injuries_suffered"/></p>
                    </xsl:if>
                    <xsl:if test="opponent_id=6">
                        <p>OPPONENT_ID:</p>
                        <p><xsl:value-of select="opponent_id"/></p>
                        <img src="../../M03_Programacio/WarriorsImages/human/huma3.jpg"></img>
                        <P>OPPONENT_WEAPON_ID:</P>
                        <p><xsl:value-of select="opponent_weapon_id"/></p>
                        <P>INJURIES_SUFFERED</P>
                        <p><xsl:value-of select="injuries_suffered"/></p>
                    </xsl:if>
                    <xsl:if test="opponent_id=7">
                        <p>OPPONENT_ID:</p>
                        <p><xsl:value-of select="opponent_id"/></p>
                        <img src="../../M03_Programacio/WarriorsImages/dwarf/dwarf1.jpg"></img>
                        <P>OPPONENT_WEAPON_ID:</P>
                        <p><xsl:value-of select="opponent_weapon_id"/></p>
                        <P>INJURIES_SUFFERED</P>
                        <p><xsl:value-of select="injuries_suffered"/></p>
                    </xsl:if>
                    <xsl:if test="opponent_id=8">
                        <p>OPPONENT_ID:</p>
                        <p><xsl:value-of select="opponent_id"/></p>
                        <img src="../../M03_Programacio/WarriorsImages/dwarf/dwarf2.jpg"></img>
                        <P>OPPONENT_WEAPON_ID:</P>
                        <p><xsl:value-of select="opponent_weapon_id"/></p>
                        <P>INJURIES_SUFFERED</P>
                        <p><xsl:value-of select="injuries_suffered"/></p>
                    </xsl:if>
                    <xsl:if test="opponent_id=9">
                        <p>OPPONENT_ID:</p>
                        <p><xsl:value-of select="opponent_id"/></p>
                        <img src="../../M03_Programacio/WarriorsImages/dwarf/dwarf3.jpg"></img>
                        <P>OPPONENT_WEAPON_ID:</P>
                        <p><xsl:value-of select="opponent_weapon_id"/></p>
                        <P>INJURIES_SUFFERED</P>
                        <p><xsl:value-of select="injuries_suffered"/></p>
                    </xsl:if>
                </div>
            </div>
            <div class="punts">
                <p>BATTLE POINTS:</p>
                <p><xsl:value-of select="battle_points"/></p>
            </div>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>
