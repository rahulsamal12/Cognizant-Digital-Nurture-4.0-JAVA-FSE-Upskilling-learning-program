console.log("Welcome to the Community Portal");

window.addEventListener("load", () => {
    alert("Page is fully loaded");
    loadPreference();
    setupEventListeners();
});

// Setup all event listeners in one place
function setupEventListeners() {
    const feedbackForm = document.getElementById("feedbackForm");
    const feedbackTextarea = document.getElementById("feedback");
    const clearPrefBtn = document.getElementById("clearPreferencesBtn");
    const locationBtn = document.getElementById("getLocationBtn");
    const feedbackImage = document.querySelector(".event-img.venue-img");

    if (feedbackForm) feedbackForm.addEventListener("submit", submitFeedback);
    if (feedbackTextarea) feedbackTextarea.addEventListener("input", countChars);
    if (clearPrefBtn) clearPrefBtn.addEventListener("click", clearPreferences);
    if (locationBtn) locationBtn.addEventListener("click", findLocation);
    if (feedbackImage) feedbackImage.addEventListener("dblclick", () => enlargeImage(feedbackImage));
}

// Submit feedback form
function submitFeedback(event) {
    event.preventDefault();
    const feedback = document.getElementById("feedback").value.trim();
    const confirmation = document.getElementById("feedbackConfirmation");

    if (feedback.length < 5) {
        alert("Please provide more detailed feedback (at least 5 characters).");
        return;
    }

    confirmation.textContent = "✅ Thank you for your feedback!";
    document.getElementById("feedback").value = "";
    countChars();  // Reset count
}

// Count characters in feedback
function countChars() {
    const feedback = document.getElementById("feedback");
    const count = document.getElementById("charCount");
    if (feedback && count) {
        count.textContent = "Characters: " + feedback.value.length;
    }
}

// Toggle image enlargement
function enlargeImage(img) {
    if (!img.classList.contains("enlarged")) {
        img.style.transform = "scale(1.5)";
        img.style.transition = "transform 0.3s ease";
        img.classList.add("enlarged");
    } else {
        img.style.transform = "scale(1)";
        img.classList.remove("enlarged");
    }
}

// Validate phone number format
function validatePhone() {
    const phone = document.getElementById("phone");
    if (phone && !/^[0-9]{10}$/.test(phone.value)) {
        alert("Please enter a valid 10-digit phone number.");
    }
}

// Save user event type preference
function savePreference() {
    const eventType = document.getElementById("eventType");
    if (eventType) {
        localStorage.setItem("preferredEventType", eventType.value);
    }
}

// Load saved user preference
function loadPreference() {
    const eventType = document.getElementById("eventType");
    const saved = localStorage.getItem("preferredEventType");
    if (eventType && saved) {
        eventType.value = saved;
    }
}

// Clear local and session storage
function clearPreferences() {
    localStorage.clear();
    sessionStorage.clear();
    alert("Preferences have been cleared.");
}

// Alert when video is ready
function videoReady() {
    alert("Video is ready to play.");
}

// Find and display user's geolocation
function findLocation() {
    const output = document.getElementById("location");
    if (!navigator.geolocation) {
        if (output) output.textContent = "Geolocation not supported.";
        return;
    }

    navigator.geolocation.getCurrentPosition(
        (position) => {
            if (output) {
                output.textContent = 
                    `Latitude: ${position.coords.latitude}, Longitude: ${position.coords.longitude}`;
            }
        },
        (error) => {
            if (output) output.textContent = "Error: " + error.message;
        },
        { enableHighAccuracy: true, timeout: 5000 }
    );
}

// Warn user before leaving if changes aren't saved
window.onbeforeunload = () => {
    return "You have unsaved changes!";
};
