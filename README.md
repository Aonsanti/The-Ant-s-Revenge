# The Ant's Revenge

The Ant's Revenge is a 2D action game where players control a character to fight against various enemies. The game features multiple levels, each with unique enemies and challenges. Players can level up, rebirth, and upgrade their stats to become stronger and unlock new enemies.

## Table of Contents

- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Classes and Concepts](#classes-and-concepts)
- [Contributing](#contributing)
- [License](#license)

## Features

- Multiple enemy characters with unique behaviors
- Player leveling and rebirth system
- Health and damage upgrades
- Different scenes for each enemy
- Main menu with options to start the game, exit, and rebirth

## Installation

- For editing source files
  1. Clone the repository:
      ```sh
      git clone https://github.com/Aonsanti/The-Ant-s-Revenge.git
      ```
  2. Open the project in your preferred IDE (e.g., Visual Studio Code).

  3. Ensure you have Java Developement Kit installed on your system.
- For running the project
  1. Simply, download a file, `The Ant's Revenge.jar`
  2. That's it! Ensure that you have Java Runtime Enviroment installed on you system.

## Usage

1. Run the `RunGame` class to start the game:
    ```sh
    javac RunGame.java
    java RunGame
    ```

	Alternatively, you can open Java ARchive file (.jre), `The Ant's Revenge.jre` at the root directory to run the  project.

2. Use the main menu to start the game, exit, or rebirth your character.

3. Control your character using the keyboard:
    - `SPACE`: Jump
    - `A`: Move left
    - `D`: Move right
    - `K`: Attack
    - `L`: Special attack

## Classes and Concepts

### Player

- `PlayerCharactor`: Represents the player character with attributes like health, attack damage, and movement.
- `PlayerLevel`: Manages the player's level and experience points.
- `PlayerRebirth`: Handles the rebirth system, resetting the player's stats and unlocking new enemies.

### Enemy

- `Enemy1_Charactor`, `Enemy2_Charactor`, `Enemy3_Charactor`, `Enemy4_Charactor`: Different enemy characters with unique attributes and behaviors.
- `PostureEnemy1`, `PostureEnemy2`, `PostureEnemy3`, `PostureEnemy4`: Manages the animations and postures of the enemies.

### Screen

- `Enemy1Scene`, `Enemy2Scene`, `Enemy3Scene`, `Enemy4Scene`: Different scenes for each enemy, handling the game logic and rendering.
- `MainMenu`: The main menu screen with options to start the game, exit, and rebirth.
- `UpStat`: Manages the player's stat upgrades.

### Object-Oriented concepts

- Constructor
- Classes
- Encapsulation
- ~~Inheritance~~
- Polymorphism
- ~~Abstract classes~~

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.