#ReadMe
Implementation description for junior homework task.

#REST API
The REST API to the example app is described below.

###1. Types of books
~~~~
book
antiqueBook
scienceJournal
~~~~

###2. Get list of Books
#####Request
GET   /books

###3. Add a new book to the list
#####Request
POST   /book 
~~~~
{
    "type": "book",
    "bookType": "REGULAR_BOOK",
    "name": "Book Title",
    "author": "Book Authore",
    "barcode": "BOOK123",
    "quantity": 2,
    "pricePerUnit": 1.5
}
~~~~

###4. Retrieve book information by providing its barcode
#####Request

GET   /book/{barcode}

###5. Update any of book detail by providing the barcode
#####Request
PUT   /book

~~~~
{
    "type": "book",
    "bookType": "REGULAR_BOOK",
    "name": "New Book Title",
    "author": "New Book Authore",
    "barcode": "BOOK123",
    "quantity": 2,
    "pricePerUnit": 1.5
}
~~~~

###6. Calculate the total price of specific book by given the barcode
#####Request
GET   /book/{barcode}/totalPrice

    
###7. Get list of all barcodes for the books in stock grouped by quantity
#####Request
GET   /books/sort
