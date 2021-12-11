// For Toggle Dropdown
let dropItems = document.querySelectorAll(".drop-item");
for (var i = 0; i < dropItems.length; i++) {
    dropItems[i].addEventListener("click", (e) => {
        if (e.target.classList.contains("arrow")) {
            let arrowParent = e.target.parentElement.parentElement;
            arrowParent.classList.toggle("showMenu");
        }

        else if (e.target.classList.contains("bx") || e.target.classList.contains("link_name")) {
            let arrowParent = e.target.parentElement.parentElement.parentElement;
            arrowParent.classList.toggle("showMenu");
        }

        else if (e.target.classList.contains("iocn-link")) {
            let arrowParent = e.target.parentElement;
            arrowParent.classList.toggle("showMenu");
        }

        else {
            e.target.classList.toggle("showMenu");
        };
    });
};

// For Side Bar
let sidebar = document.querySelector(".sidebar");
let sidebarBtn = document.querySelector(".bx-menu");
sidebarBtn.addEventListener("click", () => {
    sidebar.classList.toggle("close");
});

// For Home Page Word List
const homeWordsList = ["Welcome to LA SCALA", "READY TO BE OPENED", " RESERVATION", "Discover", "OUR STORY", "OUR STORY Description", "FRANK REYES", "Master Chef", "Amazing Delicious", "Steak Fingers & Gravy", "Special Cocktails", "Bean Salad", "Amazing Delicious Description", "Book A Table", "Discover", "OUR MENU", "Starter", "Lunch", "Dinner", "Dessert", "Alcoholic", "Drinks", "View More", "BEST PLACE OF CULINARY", "OUR GALLERY", "Reservation", "BOOK A TABLE", "Book a table details", "LA SCALA Description", "RECENT POSTS", "Egestas Fringilla Phasellus", "Arcu Cursus Euismod Quis", "Magna Etiam Tempor Viverra", "Varius Sit Amet Mattis", "GALLERY", "CONTACT INFO", "Reon, 1535 Broadway, New York", "+1 888-999-3333", "Contact@example.com", "Lunch", "Everyday", "Dinner: Mon- Thu", "18:00-21:30", "Dinner: Fri- Sun", "19:00-21:00", "Copyright @ 2019 Reon. Get The Theme"];

const menuWordsList = ["The Menu", "The Menu Details", "SALAD", "CURRY", "POTATO", "ONION AND NUTMEG SALAD........$12", "ur 100% grass-fed hand-cut top sirloin is seared to lock in the juices.", "VINEGAR AND PRUNE SALAD........$12", "Pork and fresh potato combined into chunky make it good.", "CHERVIL AND GUAVA SALAD........$12", "A crisp salad featuring chervil and fresh guava pork and fresh potato.", "GOAT AND MINT SALAD........$22", "Goat and dried mint served on a bed of lettuce. pork and fresh potato.", "STEAKHOUSE SIRLOIN........$25", "Our 100% grass-fed hand-cut top sirloin is seared to lock in the juices.", "SKINNY CARNIVORE........$12", "Genoa salami, smoked prosciutto, barrel-aged Sriracha, bocconcini.", "MEAT", "SUSHI", "TURKEY", "STEAK", "SOUP", "FISH"];

const aboutWordList = ["About Us", "About Us Details", "Our Story Details", "About Us Details 2", "OUR STAFF", "Andrew Austin", "Chef", "Tom Anderson", "Staff", "Emma Johnson", "TESTIMONIALS", "Reviews", "Lunch 12:00 - 14:00", "Everyday", "Dinner 19:00 - 21:00", "Monday – Thursday", "Dinner 18:00 - 21:30", "Friday – Sunday"];

const ourTeamWordList = ["Our Team", "Our Team Text"];

const eventsWordList = ["Our Events", "Our Events Details", "Suscipit Tellus Mauris", "READ MORE", "January 5, 2019"];

const reservationWordList = ["Reservation", "Reservation Details", "RESERVE BY PHONE", "RESERVE BY PHONE Details", "PRIVATE DINING & EVENTS", "PRIVATE DINING & EVENTS Details"];

const notFoundWordList = ["Pages Not Found", "OOPS! PAGE NOT FOUND", "GO BACK HOME"];

const commingSoonWordList = ["WE ARE COMMING SOON", "DAYS", "HOURS", "MINUTES", "SECONDES"];

const galleryWordList = ["Gallery Grid", "Gallery Grid Text"];

const blogWordList = ["Blog Sidebar", "Blog Sidebar Text", "Search", "Categories", "Search Here", "Decorate", "Even", "Gallery", "Recipe"];

let homePageFieldContainer = document.getElementById("home-page-field-container");
let menuPageFieldContainer = document.getElementById("menu-page-field-container");
let aboutPageFieldContainer = document.getElementById("about-page-field-container");
let teamPageFieldContainer = document.getElementById("team-page-field-container");
let eventsPageFieldContainer = document.getElementById("events-page-field-container");
let reservationPageFieldContainer = document.getElementById("reservation-page-field-container");
let notFoundPageFieldContainer = document.getElementById("notFound-page-field-container");
let commingSoonPageFieldContainer = document.getElementById("commingSoon-page-field-container");
let galleryPageFieldContainer = document.getElementById("gallery-page-field-container");
let blogPageFieldContainer = document.getElementById("blog-page-field-container");

homeWordsList.map(word => {
    let div = document.createElement("div");
    div.classList.add("col");
    div.innerHTML = `<label class="form-label">
                ${word}
            </label>

            <input type="text" class="form-control text-dark" value="${word}">`;

    homePageFieldContainer.appendChild(div);
});


menuWordsList.map(word => {
    let div = document.createElement("div");
    div.classList.add("col");
    div.innerHTML = `<label class="form-label">
                ${word}
            </label>

            <input type="text" class="form-control text-dark" value="${word}">`;

    menuPageFieldContainer.appendChild(div);
});

aboutWordList.map(word => {
    let div = document.createElement("div");
    div.classList.add("col");
    div.innerHTML = `<label class="form-label">
                ${word}
            </label>

            <input type="text" class="form-control text-dark" value="${word}">`;

    aboutPageFieldContainer.appendChild(div);
});

ourTeamWordList.map(word => {
    let div = document.createElement("div");
    div.classList.add("col");
    div.innerHTML = `<label class="form-label">
                ${word}
            </label>

            <input type="text" class="form-control text-dark" value="${word}">`;

    teamPageFieldContainer.appendChild(div);
});

eventsWordList.map(word => {
    let div = document.createElement("div");
    div.classList.add("col");
    div.innerHTML = `<label class="form-label">
                ${word}
            </label>

            <input type="text" class="form-control text-dark" value="${word}">`;

    eventsPageFieldContainer.appendChild(div);
});

reservationWordList.map(word => {
    let div = document.createElement("div");
    div.classList.add("col");
    div.innerHTML = `<label class="form-label">
                ${word}
            </label>

            <input type="text" class="form-control text-dark" value="${word}">`;

    reservationPageFieldContainer.appendChild(div);
});

notFoundWordList.map(word => {
    let div = document.createElement("div");
    div.classList.add("col");
    div.innerHTML = `<label class="form-label">
                ${word}
            </label>

            <input type="text" class="form-control text-dark" value="${word}">`;

    notFoundPageFieldContainer.appendChild(div);
});

commingSoonWordList.map(word => {
    let div = document.createElement("div");
    div.classList.add("col");
    div.innerHTML = `<label class="form-label">
                ${word}
            </label>

            <input type="text" class="form-control text-dark" value="${word}">`;

    commingSoonPageFieldContainer.appendChild(div);
});

galleryWordList.map(word => {
    let div = document.createElement("div");
    div.classList.add("col");
    div.innerHTML = `<label class="form-label">
                ${word}
            </label>

            <input type="text" class="form-control text-dark" value="${word}">`;

    galleryPageFieldContainer.appendChild(div);
});

blogWordList.map(word => {
    let div = document.createElement("div");
    div.classList.add("col");
    div.innerHTML = `<label class="form-label">
                ${word}
            </label>

            <input type="text" class="form-control text-dark" value="${word}">`;

    blogPageFieldContainer.appendChild(div);
});