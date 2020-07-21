package book

import aquarium.Aquarium

open class Book (title: String, author: String) {

    private var currentPage = 1

    open fun readPage() {
        currentPage++
    }
}

class EBook(title: String, author: String, format: String = "text"): Book(title, author) {

    private var wordsRead: Int = 1

    override fun readPage() {
        wordsRead += 250
    }
}