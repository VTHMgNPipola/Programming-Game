# Programming Game
A game when you make the game!</br>
A GUI Aplication when you write a code, compile and run! It's easy and simple!

# Command List
This game has various commands (the format showed below is like Java pattern regex):</br>
`print .*` prints a string in the console without adding a new line</br>
`println .*` prints a string int the console adding a new line</br>
`mov .* .*` move the value of the first parameter to the second parameter (type accepted: string, int, float and boolean)</br>
`add .* .*` add the first value to the second value (type accepted: string, int, float)</br>
`sub .* .*` subtract the first value of the second value (type accepted: int, float)</br>
`mlt .* .*` multiply the second value for the first value (type accepted: int, float)</br>
`div .* .*` divides the second value for the first value (type accepted: int, float)</br>
`string .* (= .*)?` Defines a string variable</br>
`int .* (= .*)?` Defines a integer variable</br>
`float .* (= .*)?` Defines a float variable</br>
`boolean .* (= .*)?` Defines a boolean variable</br>
`stopfor \\d*` Sleep application for an specific time (milliseconds)</br>
`goto .* .* times` Redirect application for an specific line (line is defined for the first parameter), and continue without returning when reach a value (defined by second parameter, if parameter is 0, the loop will be infinite)</br>
`clear` Clear the console, simply</br>
`newline` Adds a new line in the console</br>
Note: a semicolon (';') can be added at the final of "print" and "println" methods, only for marking, if the string printed has a space in final.

## Theorical value
The ACC value is an integer value that you can only manipulate by mov, add, sub, mlt and div commands, and can print so. This value is not used often, but is helpful for a few applications.
