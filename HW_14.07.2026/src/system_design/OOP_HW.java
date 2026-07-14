import java.util.ArrayList;
public class OOP_HW {
    public static void main(String[] args) {
        Library library1 = new Library("1st Library");
        Library library2 = new Library("2nd Library");
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 10.99);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 12.99);
        Book book3 = new Book("1984", "George Orwell", 9.99);
        Book book4 = new Book("Pride and Prejudice", "Jane Austen", 8.99);
        Book book5 = new Book("The Catcher in the Rye", "J.D. Salinger", 11.99);
        library1.addBook(book1);
        library1.addBook(book2);
        library1.addBook(book3);
        library2.addBook(book4);
        library2.addBook(book5);
        library2.addBook(book3);
        library1.ShowBooks();
        library2.ShowBooks();

        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");
        Student student3 = new Student("Charlie");
        Student student4 = new Student("David");
        Student student5 = new Student("Eve");
        Student student6 = new Student("Frank");
        Course course1 = new Course("Math", student1);
        Course course2 = new Course("Physics", student2);
        student1.enroll(course1);
        student2.enroll(course1);
        student3.enroll(course1);
        student4.enroll(course2);
        student5.enroll(course2);
        student6.enroll(course2);
        course1.showStudents();
        course2.showStudents();

        Employee employee1 = new Employee("John", 50000);
        Employee employee2 = new Employee("Jane");
    }
}

// 1
class Book{
    private String title;
    private String author;
    private double price;
    /**
     * Constructs a new Book object with the specified title, author, and price.
     * @param title the title of the book
     * @param author the author of the book
     * @param price the price of the book
     */
    Book(String title, String author, double price){
        this.title = title;
        this.author = author;
        this.price = price;
    }
    /**
     * Returns the title of the book.
     * @return the title of the book
     */
    public String getTitle(){
        return this.title;
    }
    /**
     * Returns the author of the book.
     * @return the author of the book
     */
    public String getAuthor(){
        return this.author;
    }
    /**
     * Returns the price of the book.
     * @return the price of the book
     */
    public double getPrice(){
        return this.price;
    }
    /**
     * Sets the title of the book.
     * @param title the new title of the book
     */
    public void setTitle(String title){
        this.title = title;
    }
    /**
     * Sets the author of the book.
     * @param author the new author of the book
     */
    public void setAuthor(String author){
        this.author = author;
    }
    /**
     * Sets the price of the book.
     * @param price the new price of the book
     */
    public void setPrice(double price){
        this.price = price;
    }
}

class Library{
    protected String libname = "My Library";
    private final ArrayList<Book> books;
    /**
     * Constructs a new Library object with the specified library name.
     * @param libname the name of the library
     */
    Library(String libname){
        this.libname = libname;
        this.books = new ArrayList<>();      
    }
    private int count = 0;
    /**
     * Adds a book to the library's collection.
     * @param book the book to be added
     */
    public void addBook(Book book){
        this.books.add(book);
        count++;
    }
    /**
     * Displays the details of all books in the library's collection.
     */
    void ShowBooks(){
        for(int i=0; i<count; i++){
            System.out.println("Title: " + this.books.get(i).getTitle() + ", Author: " + this.books.get(i).getAuthor() + ", Price: " + this.books.get(i).getPrice());
        }
    }
}

class Student{
    private final String name;
    private static int idCounter = 0;
    private final int id;
    /**
     * Constructs a new Student object with the specified name.
     * @param name the name of the student
     */
    Student(String name){
        this.name = name;
        this.id = ++idCounter;
    }
    /**
     * Returns the name of the student.
     * @return the name of the student
     */
    public String getName(){
        return this.name;
    }
    /**
     * Returns the ID of the student.
     * @return the ID of the student
     */
    public int getId(){
        return this.id;
    }
    /**
     * Enrolls the student in the specified course.
     * @param course the course to enroll the student in
     */
    public void enroll(Course course){
        course.addStudent(this);
    }
}

class Course{
    private final String courseName;
    private final ArrayList<Student> capacity;
    /**
     * Constructs a new Course object with the specified course name and initial student.
     * @param courseName the name of the course
     * @param student the initial student to be enrolled in the course
     */
    Course(String courseName, Student student){
        this.courseName = courseName;
        this.capacity = new ArrayList<>();
        this.capacity.add(student);
    }
    /**
     * Returns the name of the course.
     * @return the name of the course
     */
    public String getCourseName(){
        return this.courseName;
    }
    /**
     * Adds a student to the course's capacity.
     * @param student the student to be added
     */
    public void addStudent(Student student){
        this.capacity.add(student);
    }
    /**
     * Displays the names of all students enrolled in the course.
     */
    public void showStudents(){
        for(int i=0; i<this.capacity.size(); i++){
            System.out.println("Student " + this.capacity.get(i).getName() + " is enrolled in the course: " + this.courseName);
        }
    }
}

class Employee{
    private final String name;
    private final int Salary;
    /**
     * Constructs a new Employee object with the specified name and salary.
     * @param name the name of the employee
     * @param Salary the salary of the employee
     */
    Employee(String name, int Salary){
        this.name = name;
        this.Salary = Salary;
    }
    /**
     * Constructs a new Employee object with the specified name and a default salary of 0.
     * @param name the name of the employee
     */
    Employee(String name){
        this.name = name;
        this.Salary = 0;
    }
}

