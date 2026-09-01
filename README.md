# Create: Mate
A Create addon that adds the beloved Yerba-Mate-derived drink: Club-Mate!

## Getting Started 
To initialize the repository run `./gradlew --refresh-dependencies`.
To run [DataGen](https://docs.neoforged.net/docs/resources/#data-generation) run `./gradlew runData`
To build and start a development Minecraft instance run `./gradlew runClient`.

# Working with textures
Textures are saved as `.ase` files. Items are stored in one file, divided into slices. To export the finished textures
as separate files run `aseprite -b items.ase --save-as {slice}.png --split-slices`. Be sure to keep slice names inside
Aseprite the same as item names.

## Acknowledgements
- Repository template from [NeoForgeMDKs](https://github.com/NeoForgeMDKs/MDK-1.21.1-ModDevGradle)
- [NeoForge Docs](https://docs.neoforged.net/)
- [Aseprite repository](https://github.com/aseprite/aseprite)

## License
This project is licensed under GNU GPLv3 (see [LICENSE.txt](./LICENSE.txt)).

