# Drawing-Program
A simple console version of a drawing program [fun]
# Description 
At this time, the functionality of the program is quite limited, but this might change in the future. 
In a nutshell, the program should work as follows:
 1. Create a new canvas
 2. Start drawing on the canvas by issuing various commands
 3. Quit
 
```
Command 		Description
C w h           Create a new canvas of width w and height h.
L x1 y1 x2 y2   Create a new line of 'x' from (x1,y1) to (x2,y2). Only support
                horizontal or vertical lines.
R x1 y1 x2 y2   Create a new rectangle, (x1,y1) is upper left corner & (x2,y2) is
                lower right corner.
B x y c         Fill the entire area around (x,y) with "colour" c.
                Same as that of the "bucket fill" tool in paint programs.
Q               Quit.

H <Command>     For getting the command help Eg: for getting the help for Canvas
                enter : H C
```
### Steps to Test, Package and run from commandline
_Go to the project root directory and run below steps,_
- **For Running the Test:** *
    - ``` ./mvnw test```
- **For Package and Run the jar  :** *
     - Package: 
       -  ``` ./mvnw clean package shade:shade```
     - For run the above packaged jar:  *
        - ```cd target && java -jar drawing-program-1.0.jar ```
- **Run the app from source:** *
    -  ```./mvnw exec:java```
- **Run the app using script**_(Assume using *nix OS)_:
    - ```./run.sh```
       
 _(**Windows**: use **./mvnw.cmd**; **Linux/Mac**: use just **./mvnw**)_*

## Sample I/O
```
Below is a sample run of the program. User input is prefixed with enter command:

enter command: C 20 4
----------------------
|                    |
|                    |
|                    |
|                    |
----------------------

enter command: L 1 2 6 2
----------------------
|                    |
|xxxxxx              |
|                    |
|                    |
----------------------

enter command: L 6 3 6 4
----------------------
|                    |
|xxxxxx              |
|     x              |
|     x              |
----------------------

enter command: R 14 1 18 3
----------------------
|             xxxxx  |
|xxxxxx       x   x  |
|     x       xxxxx  |
|     x              |
----------------------

enter command: B 10 3 o
----------------------
|oooooooooooooxxxxxoo|
|xxxxxxooooooox   xoo|
|     xoooooooxxxxxoo|
|     xoooooooooooooo|
----------------------
```
## __Design Patterns used:__

1. Command Pattern
   1. Undo/Redo operations are very useful in Drawing apps.
   2. This pattern is useful for performing similar process
   3. This pattern will help to encapsulate the executor from the client, hence it is easy to introduce new commands in future.
2. Factory Method Pattern

