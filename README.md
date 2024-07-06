# Powerball Console Application

This Java console application provides functionalities related to the Powerball lottery game. It pulls Powerball drawing data since 2020 (due to new options per PowerBall) and offers features to print drawings, calculate the most occurring white balls and Powerball, and generate a combination that has never been drawn before.

## Features

- **Pull Powerball Drawings**: Fetches Powerball drawings from 2020 onwards.
- **Print Drawings**: Displays all the Powerball drawings.
- **Calculate Most Occurring Balls**: Identifies the most frequently drawn white balls and the Powerball.
- **Generate Unique Combination**: Creates a combination of numbers that has never been drawn in the previous drawings.

## Requirements

- Java 11 or higher
- Internet connection (for fetching drawing data)

## Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/powerball-console-app.git
    ```
2. Navigate to the project dist directory:
    ```bash
    cd dist
    ```
3. Run the application:
    ```bash
    java -jar PB_Console.jar
    ```

## Usage

Once the application is running, you will be presented with a menu of options:

1. **Print Drawings**: Print all Powerball drawings since 2020.
2. **Calculate Most Occurring Balls**: Calculate and display the most frequently drawn white balls and the Powerball.
3. **Generate Unique Combination**: Generate a new combination of numbers that has never been drawn before.
4. **Exit**: Exit the application.

Follow the on-screen instructions to navigate through the menu and utilize the application's features.

## Example

Here's an example of the output for each feature:

### Print Drawings
- Date: 2024-06-29T00:00:00 Combo: 26 51 54 61 69 25
- Date: 2024-07-01T00:00:00 Combo: 05 09 32 39 55 09
- Date: 2024-07-03T00:00:00 Combo: 02 26 33 55 57 22

### Calculate Most Occurring White Balls
- Ball: 1, Occurrences: 124
- Ball: 2, Occurrences: 123
- Ball: 3, Occurrences: 130

### Calculate Most Occurring Power Balls
- Ball: 1, Occurrences: 56
- Ball: 2, Occurrences: 53
- Ball: 3, Occurrences: 54

### Generate Unique Quick Pick Combination
- Combo - 3 29 48 51 59 25

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## Contact

If you have any questions or suggestions, please open an issue or contact [Stephen Blevins](mailto:scbdev2021@gmail.com).


