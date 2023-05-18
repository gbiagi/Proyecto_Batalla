from lxml import etree
import os

# Llegir un arxiu XML
def read_xml(path):
   file = open(path, 'r', encoding='utf-8')
   string = file.read()
   file.close()
   return bytes(bytearray(string, encoding='utf-8'))

# Escriure un arxiu HTML
def write_html(path, html):
   file = open(path, 'w', encoding='utf-8')
   file.write(html)
   file.close()

# Crear html
def transform(xmlTree):
   # Crear l'arbre XSL per l'index de totes les noticies
   xslmicro = read_xml('./xml/template.xsl')
   xslTreemicro = etree.XML(xslmicro)
   # Transformar l'arxiu xml segons l'arxiu template.xsl
   transform = etree.XSLT(xslTreemicro)
   htmlDom = transform(xmlTree)
   htmlResult = etree.tostring(htmlDom, pretty_print=True).decode("utf-8")
   write_html("./html/battle.html", htmlResult)

# Crear l'arbre XML
xml = read_xml('./xml/battle.xml')
xmlTree = etree.XML(xml)

# Generar l'arxiu
transform(xmlTree)
