> [!IMPORTANT]  
> The current README is 1-3 commits behind, see below for reasoning
<details>
  <summary>reasoning</summary>
  
  commit [76252b0](https://github.com/Hehhehehee/JavaSandGame/commit/76252b0fc465cc7bbd178778f06e3edfa765a6a2) made the lastest release and this README outdated, i dont have time for fixing this as of now, but a fix will come some day
  </details>
  
# readme
so, this is a simple java sand game, my first java project too i guess so maybe probably
## developing
clone the repository, edit the files as you wish (the code was written in jdk 18)
### adding elements
#### solid elements
solid elements are stored at main.tiles.elements.solids <br>
adding a behaviorless solid is as simple as
```java
gameMap.addElement(new Tile(COLOR, NAME))
```
adding custom behavior is somewhat complex, so i will not add it in here, to add liquids, or powders, just replace Tile by Liquid and Powder respectively

after that you want to go to
### building
to build it is as simple as javac,
```
cd /path/to/the/repo/in/your/system/src
```
```
javac -cp . main/Main.java -d out
```
now that you have built it, you want to run the game
### running
running is as simple as running the main class (main.Main)
```
cd out
```
```
java main.Main
```
## playing
so, two windows will open
the right side window with the dropdown, is where you choose a element to place in, there are <br> 263 elements
<details>
  <summary>what are the weird elements</summary>
the 256 elements are test liquids with names ranging from a to hd <br>
their color is the range from 0x000000 to 0x00FF00 <br>
  </details>
the other elements are pretty self explanatory <br>
to place an element in the grid (leftmost screen), just hold down any key, and it will start to materialize

## apology
this code is horrifyingly bad and should be completely obliterated from reality, it has no naming scheme, and no comments at all, i am sorry...
## why
i just thought it would be interesing to try to repilicate this common game idea
