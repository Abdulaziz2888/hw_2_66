package com.example.hw_2_66

data class Book(
    val id: String,
    val title: String,
    val author: String,
    val description: String,
    val imageUrl: String = "",
    val genre: String,
    val year: Int
)

data class User(val name: String, val email: String)

val sampleBooks = listOf(
    Book(
        "1",
        "The Great Gatsby",
        "F. Scott Fitzgerald",
        "A novel set in the 1920s that critiques the American dream.",
        "https://example.com/gatsby.jpg",
        "Fiction",
        1925
    ),
    Book(
        "2",
        "Moby Dick",
        "Herman Melville",
        "A story of obsession and revenge against a white whale.",
        "https://example.com/moby.jpg",
        "Adventure",
        1851
    ),
    Book(
        "3",
        "1984",
        "George Orwell",
        "A dystopian novel about a totalitarian regime.",
        "https://example.com/1984.jpg",
        "Dystopian",
        1949
    ),
    Book(
        "4",
        "To Kill a Mockingbird",
        "Harper Lee",
        "A novel set in the South that explores racial injustice.",
        "https://example.com/mockingbird.jpg",
        "Classic",
        1960
    ),
    Book(
        "5",
        "Pride and Prejudice",
        "Jane Austen",
        "A classic romance novel about the Bennet family.",
        "https://example.com/pride.jpg",
        "Romance",
        1813
    ),
    Book(
        "6",
        "Brave New World",
        "Aldous Huxley",
        "A dystopian novel set in a future society of stability.",
        "https://example.com/bravenewworld.jpg",
        "Dystopian",
        1932
    ),
    Book(
        "7",
        "The Catcher in the Rye",
        "J.D. Salinger",
        "A story about teenage rebellion and alienation.",
        "https://example.com/catcher.jpg",
        "Fiction",
        1951
    ),
    Book(
        "8",
        "Crime and Punishment",
        "Fyodor Dostoevsky",
        "A psychological drama about guilt and redemption.",
        "https://example.com/crimepunishment.jpg",
        "Classic",
        1866
    ),
    Book(
        "9",
        "Wuthering Heights",
        "Emily Brontë",
        "A passionate love story set on the Yorkshire moors.",
        "https://example.com/wutheringheights.jpg",
        "Romance",
        1847
    ),
    Book(
        "10",
        "The Odyssey",
        "Homer",
        "An epic poem about the adventures of Odysseus.",
        "https://example.com/odyssey.jpg",
        "Epic",
        -800
    ),
    Book(
        "11",
        "The Hobbit",
        "J.R.R. Tolkien",
        "A fantasy novel about a hobbit's journey to reclaim treasure.",
        "https://example.com/hobbit.jpg",
        "Fantasy",
        1937
    ),
    Book(
        "12",
        "Frankenstein",
        "Mary Shelley",
        "A novel about a scientist who creates a living creature.",
        "https://example.com/frankenstein.jpg",
        "Horror",
        1818
    ),
    Book(
        "13",
        "Dracula",
        "Bram Stoker",
        "The story of Count Dracula's attempt to move from Transylvania to England.",
        "https://example.com/dracula.jpg",
        "Horror",
        1897
    ),
    Book(
        "14",
        "The Picture of Dorian Gray",
        "Oscar Wilde",
        "A novel about a man whose portrait ages while he remains young.",
        "https://example.com/doriangray.jpg",
        "Gothic",
        1890
    ),
    Book(
        "15",
        "Les Misérables",
        "Victor Hugo",
        "A story about justice, love, and redemption in post-revolutionary France.",
        "https://example.com/lesmiserables.jpg",
        "Historical Fiction",
        1862
    ),
    Book(
        "16",
        "War and Peace",
        "Leo Tolstoy",
        "A historical novel set during the Napoleonic Wars.",
        "https://example.com/warandpeace.jpg",
        "Historical Fiction",
        1869
    ),
    Book(
        "17",
        "The Brothers Karamazov",
        "Fyodor Dostoevsky",
        "A philosophical novel exploring faith, doubt, and morality.",
        "https://example.com/brotherskaramazov.jpg",
        "Philosophical Fiction",
        1880
    ),
    Book(
        "18",
        "Anna Karenina",
        "Leo Tolstoy",
        "A tragic novel about a woman's doomed love affair.",
        "https://example.com/annakarenina.jpg",
        "Romance",
        1877
    ),
    Book(
        "19",
        "The Call of the Wild",
        "Jack London",
        "The story of a dog who returns to the wild in the Klondike.",
        "https://example.com/callofthewild.jpg",
        "Adventure",
        1903
    ),
    Book(
        "20",
        "The Jungle Book",
        "Rudyard Kipling",
        "A collection of stories about a boy raised by wolves in the jungle.",
        "https://example.com/junglebook.jpg",
        "Adventure",
        1894
    ),
    Book(
        "21",
        "Catch-22",
        "Joseph Heller",
        "A satirical novel about the absurdity of war.",
        "https://example.com/catch22.jpg",
        "Satire",
        1961
    ),
    Book(
        "22",
        "The Shining",
        "Stephen King",
        "A horror novel about a family trapped in a haunted hotel.",
        "https://example.com/shining.jpg",
        "Horror",
        1977
    ),
    Book(
        "23",
        "The Road",
        "Cormac McCarthy",
        "A post-apocalyptic novel about afather and son surviving in a desolate world.",
        "https://example.com/road.jpg",
        "Dystopian",
        2006
    ),
    Book(
        "24",
        "The Girl on the Train",
        "Paula Hawkins",
        "A psychological thriller about a woman who becomes involved in a disappearance case.",
        "https://example.com/girlonthetrain.jpg",
        "Thriller",
        2015
    ),
    Book(
        "25",
        "Gone with the Wind",
        "Margaret Mitchell",
        "A historical novel set during the American Civil War and Reconstruction.",
        "https://example.com/gonewiththewind.jpg",
        "Historical Fiction",
        1936
    ),
    Book(
        "26",
        "The Alchemist",
        "Paulo Coelho",
        "A philosophical novel about a shepherd's journey to find treasure.",
        "https://example.com/alchemist.jpg",
        "Adventure",
        1988
    ),
    Book(
        "27",
        "The Fault in Our Stars",
        "John Green",
        "A romantic novel about two teenagers who fall in love while battling cancer.",
        "https://example.com/faultinourstars.jpg",
        "Romance",
        2012
    ),
    Book(
        "28",
        "The Night Circus",
        "Erin Morgenstern",
        "A fantasy novel about a magical circus that appears without warning.",
        "https://example.com/nightcircus.jpg",
        "Fantasy",
        2011
    ),
    Book(
        "29",
        "The Hunger Games",
        "Suzanne Collins",
        "A dystopian novel where children fight to the death in an arena for entertainment.",
        "https://example.com/hungergames.jpg",
        "Dystopian",
        2008
    ),
    Book(
        "30",
        "A Tale of Two Cities",
        "Charles Dickens",
        "A historical novel set during the French Revolution.",
        "https://example.com/taleoftwocities.jpg",
        "Historical Fiction",
        1859
    ),
    Book(
        "31",
        "The Divine Comedy",
        "Dante Alighieri",
        "An epic poem describing the journey of a man through Hell, Purgatory, and Heaven.",
        "https://example.com/divinecomedy.jpg",
        "Epic",
        1320
    ),
    Book(
        "32",
        "Don Quixote",
        "Miguel de Cervantes",
        "A novel about a man who sets out to revive chivalry in a world that no longer needs it.",
        "https://example.com/donquixote.jpg",
        "Satire",
        1605
    ),
    Book(
        "33",
        "The Outsiders",
        "S.E. Hinton",
        "A novel about the struggles of teenagers from different social classes.",
        "https://example.com/outsiders.jpg",
        "Young Adult",
        1967
    ),
    Book(
        "34",
        "The Secret Garden",
        "Frances Hodgson Burnett",
        "A children's novel about a girl who finds a secret garden and brings it to life.",
        "https://example.com/secretgarden.jpg",
        "Children's",
        1911
    ),
    Book(
        "35",
        "Little Women",
        "Louisa May Alcott",
        "A story about four sisters growing up in the 19th century.",
        "https://example.com/littlewomen.jpg",
        "Classic",
        1868
    )
)