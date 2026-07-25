import os
import requests
import genanki

# List of 50 common Swahili nouns with their English counterparts
# (English is only used for image searching and will NOT appear on the cards.)
swahili_nouns = [
    ("Mtu", "person"),
    ("Nyumba", "house"),
    ("Chakula", "food"),
    ("Maji", "water"),
    ("Gari", "car"),
    ("Kitabu", "book"),
    ("Shule", "school"),
    ("Meza", "table"),
    ("Kiti", "chair"),
    ("Mti", "tree"),
    ("Jua", "sun"),
    ("Mwezi", "moon"),
    ("Nyota", "star"),
    ("Mlango", "door"),
    ("Dirisha", "window"),
    ("Kitanda", "bed"),
    ("Nguo", "clothes"),
    ("Viatu", "shoes"),
    ("Kalamu", "pen"),
    ("Karatasi", "paper"),
    ("Mtoto", "child"),
    ("Rafiki", "friend"),
    ("Familia", "family"),
    ("Fedha", "money"),
    ("Kazi", "work"),
    ("Simu", "phone"),
    ("Dunia", "earth"),
    ("Mlima", "mountain"),
    ("Bahari", "sea"),
    ("Mto", "river"),
    ("Barabara", "road"),
    ("Mji", "city"),
    ("Kijiji", "village"),
    ("Soko", "market"),
    ("Duka", "shop"),
    ("Samaki", "fish"),
    ("Ndege", "bird"),
    ("Mbwa", "dog"),
    ("Paka", "cat"),
    ("Ng'ombe", "cow"),
    ("Mbuzi", "goat"),
    ("Kuku", "chicken"),
    ("Macho", "eyes"),
    ("Masikio", "ears"),
    ("Mkono", "hand"),
    ("Mguu", "leg"),
    ("Kichwa", "head"),
    ("Moyo", "heart"),
    ("Wakati", "time"),
    ("Siku", "day"),
]

# -------------------------------------------------------------------
# Create the Anki Model
# Front: Swahili word
# Back: Image (No English)
# -------------------------------------------------------------------

style = """
.card {
    font-family: Arial;
    font-size: 24px;
    text-align: center;
    color: black;
    background-color: white;
}

img {
    max-width: 400px;
    max-height: 400px;
    margin-top: 20px;
}
"""

swahili_model = genanki.Model(
    1607392319,
    "Swahili Image Model",
    fields=[
        {"name": "Swahili"},
        {"name": "Image"},
    ],
    templates=[
        {
            "name": "Card 1",
            "qfmt": "<div>{{Swahili}}</div>",
            "afmt": "{{FrontSide}}<hr id='answer'><div>{{Image}}</div>",
        },
    ],
    css=style,
)

# -------------------------------------------------------------------
# Create the Deck
# -------------------------------------------------------------------

swahili_deck = genanki.Deck(
    2059400110,
    "50 Common Swahili Nouns (Visual)",
)

media_files = []

print("Starting image download and deck generation...")

# -------------------------------------------------------------------
# Download images and create cards
# -------------------------------------------------------------------

for sw_word, en_keyword in swahili_nouns:
    image_filename = f"{en_keyword}.jpg"
    image_url = f"https://loremflickr.com/600/400/{en_keyword}"

    try:
        # Download the image
        response = requests.get(image_url, timeout=10)

        if response.status_code == 200:
            with open(image_filename, "wb") as f:
                f.write(response.content)

            # Create the Anki note
            note = genanki.Note(
                model=swahili_model,
                fields=[
                    sw_word,
                    f'<img src="{image_filename}">',
                ],
            )

            swahili_deck.add_note(note)
            media_files.append(image_filename)

            print(f"Added: {sw_word}")

        else:
            print(f"Failed to find image for: {sw_word}")

    except Exception as e:
        print(f"Error processing {sw_word}: {e}")

# -------------------------------------------------------------------
# Save the deck
# -------------------------------------------------------------------

package = genanki.Package(swahili_deck)
package.media_files = media_files
package.write_to_file("swahili_nouns_visual.apkg")

# -------------------------------------------------------------------
# Clean up downloaded images
# -------------------------------------------------------------------

for file in media_files:
    if os.path.exists(file):
        os.remove(file)

print("\nSuccess! Your file 'swahili_nouns_visual.apkg' has been created.")
print("You can now import this file directly into Anki.")