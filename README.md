# verkeerslicht

We gaan nu een complexer toestandsdiagram behandelen. Het systeem is een eenvoudig
verkeerslicht (rood, groen en geel) met een waarschuwingsstand (knipperend geel licht). Het
knipperende gele licht geeft dan aan dat het kruispunt ongeregeld is en dat de normale verkeerregels
in acht genomen dienen te worden (voorrangsweg, rechts voorrang op links etc.). Deze
waarschuwingsstand wordt actief als er een storing optreedt of op rustige kruispunten tijdens bijv. de
nacht.

## werking

Het verkeerslicht werkt als volgt. Als het systeem opstart, gaat het gele licht knipperen. Als er via de
console een teken wordt ontvangen gaat het verkeerslicht over naar de Stop state (signaal
Rood). Na 3 seconden wordt de Drive state (signaal Groen) actief en na 5 seconden wordt de Break
state (signaal Geel) actief. Na 2 seconden gaat het systeem weer naar de Stop state. In Figuur 1
(hieronder) is de state machine voor dit systeem te vinden.

![Figuur 1 - verkeerslicht](/src/main/resources/Verkeerslicht_STM.png)