# Calculator by SpicyPark
## About
**Latest full release:** v3.2.0<br>
**Latest pre-release:** N/A

This is a multi-function graphing calculator that has been developed by SpicyPark since April of 2023. It is currently in its fourth major iteration. The calculator currently has four modes with one more arriving soon. Any release past the very first alpha version of 3.0.0 has runnable files under the folder `release` in the event that you wish to try an earlier version of the calculator.

For more information or changelogs of the calculator, visit the releases page at https://github.com/SpicyPark/Calculator/releases or the wiki at https://github.com/SpicyPark/Calculator/wiki.

**NOTICE: The following information is accurate as of the latest full release, denoted above, of the calculator.**

## Installing the program
**Java 8 or later is required to run this program. Please ensure you have either Java 8 or a later Java installment on your device.**
### Using Visual Studio Code
To run the program using VSCode, you may download the source code by either navigating to the latest release and downloading the included `.zip` or by cloning the repository. Following the download, unzip the contents of the `.zip` file and open it with VSCode; you may then run the program from there.
### Using the executable file
To run the program using the `.exe`, navigate to the latest release and download the file ending with `.exe`. You may simply double click the `.exe` file to run the program. Note that you still must have Java.
### Using the JAR file
To run the program using the `.jar`, navigate to the latest release and download the file ending with `.jar`. You may simply double click the `.jar` file to run the program.
## Running the program
### Arithmetic
- Decimal outputs are rounded to 5 places.
- Do not put spaces in your equation.
- Parentheses and exponentiation are currently unsupported.

Examples of currently viable inputs:
- `3*4/7`
- `-34.52+4*43.3332*8-45.333*1.313`
- `2+5*3-1`

Examples of currently invalid inputs:
- `3n+4`
- `3 + 4 - 3 * 5`
- `(3+2)-4^3`

After inputting your equation, press the submit button. Your solution will appear in the solution box. If the solution is incorrect, please report the issue and include both your inputted equation and the erroneous solution. If you wish to clear your input, press the clear button.
### Graphing
- The x axis goes from -19 to 19 and the y axis goes from -17 to 17.
- Do not put spaces in your equation.
- Parentheses are currently unsupported.
- For fractional values, use decimals (0.333 instead of 1/3).
- Supported operators are `+`, `-`. and `^`.
- Use only `x` as your variable.
- `sinx`, `cosx`, and `tanx` are the only currently supported trig functions, and they will only work exactly as shown here. Adding terms or multiplying (such as 3sinx or sinx+3x+2) is not currently supported.
- `ax^x` (`a` being an arbitrary value) is supported. `x^bx` (`b` being an arbitrary value) is not supported.
- You may toggle graph color, gridlines, and numbers in the Settings page.

Examples of currently viable inputs:
- `2x^2-4x+2`
- `-0.333x^6-3x^4+3.4`
- `sinx`

Examples of currently invalid inputs:
- `3sinx+4`
- `(3x+2)^2`
- `3^x^3+4`

After inputting your equation, press the submit button. The equation, if valid, will be graphed in a line of your selected color. Multiple equations may be graphed, so pressing submit will overlay a new graph over any previous graphs. If the solution is incorrect, please report the issue and include both your inputted equation and the erroneous solution. If you wish to clear all graphs and your input, press the clear button.
### Conversion
- Only numerical (integer and decimal) inputs are valid in the input box.
- Invalid conversion (such as kilometers to gallons or grams to feet) are caught.
- The middle "to" box is merely a visual guide and otherwise serves no functional purpose.
- Decimal outputs are rounded to 5 places.
- Units listed in the dropdowns default to all, however you may toggle between Distance, Weight, Volume, and All in the Settings page.

To convert a number of values of one measurement to another, first input your number (which may be a decimal or integer, positive or negative). Next, select in the leftmost dropdown box what unit to convert *from*, and in the rightmost dropdown box what unit to convert *to*. Pressing submit will give your converted value rounded to five decimal places, and pressing clear will clear all of the boxes to their default states.
### Random
#### Number Generator
- Specify an upper bound for numbers generated in the Settings page.
- Only positive integer values are valid in the input box.
- The randomly generated number has a possible range from 1 to the upper bound.

Examples of currently viable inputs:
- `3`
- `53245`
- `46`

Examples of currently invalid inputs:
- `-15`
- `5.5`
- `2,399`

After you input a value in the box in the Settings page, press enter and the program will save your upper bound. You may then generate as many numbers as you wish and may also change the upper bound at any time.

#### Coin Flipper
- The flip button outputs either heads or tails.
- Pressing flip may or may not change heads to tails in the output each time as flips are independent.
