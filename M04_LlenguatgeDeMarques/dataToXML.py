import mysql.connector
import xml.etree.ElementTree as ET

# First of all, you need to install mysql.connector package
# To do that you need to have pip in your system.
# PIP for Windows: install this file https://bootstrap.pypa.io/get-pip.py
# then execute the file in the command line with "python get-pip.py"
#PIP for UBUNTU: write in terminal, sudo apt update. Then sudo apt install python3-pip
# Once you install pip, you can
# write pip install mysql-connector-python in the terminal

# Then, to create the xml you need to set your the connection to your own BBDD
conexion = mysql.connector.connect(user='root',password='1234',
                                   host='localhost', database='BatallaDeRaces',
                                   port='3306')
print(conexion)

cursor = conexion.cursor()
cursor.execute("Select * from battle;")

batalla = cursor.fetchall()

# Create variables
usu = []
for battle in batalla:
    usu.append(battle)

root = ET.Element("xml")
var = list()
for i in range(len(usu)):
    var.append(i)
for i in range(len(usu)):
    var[i] = ET.SubElement(root, "battle",id=str(var[i]))
    ET.SubElement(var[i], "battle_id").text = str(usu[i][0])
    ET.SubElement(var[i], "player_id").text = str(usu[i][1])
    ET.SubElement(var[i], "warrior_id").text = str(usu[i][2])
    ET.SubElement(var[i], "warrior_weapon_id").text = str(usu[i][3])
    ET.SubElement(var[i], "opponent_id").text = str(usu[i][4])
    ET.SubElement(var[i], "opponent_weapon_id").text = str(usu[i][5])
    ET.SubElement(var[i], "injuries_caused").text = str(usu[i][6])
    ET.SubElement(var[i], "injuries_suffered").text = str(usu[i][7])
    ET.SubElement(var[i], "battle_points").text = str(usu[i][8])

tree = ET.ElementTree(root)
tree.write("./xml/battle.xml")

cursor.close()
conexion.close()