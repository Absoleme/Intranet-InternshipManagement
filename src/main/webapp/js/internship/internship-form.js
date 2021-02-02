let currentTab = 0; // Current tab is set to be the first tab (0)

$(() => {
    showTab(currentTab); // Display the current tab
});

function showTab(index) {

    // This function will display the specified tab of the form ...
    let tabs = $('.tab');
    $(tabs).each((i, element) => {
        if (i === index) {
            $(element).addClass("d-block");
            $(element).removeClass("d-none");
        } else {
            $(element).addClass("d-none");
            $(element).removeClass("d-block");
        }
    });
    // ... and fix the Previous/Next buttons:
    if (index === 0) {
        $('#prevBtn').css('display', 'none');
    } else {
        $('#prevBtn').css('display', 'inline');
    }
    if (index === (tabs.length - 1)) {
        $('#nextBtn').html('Submit');
    } else {
        $('#nextBtn').html('Next');
    }

    // ... and run a function that displays the correct step indicator:
    //fixStepIndicator(n);
}

// This function will figure out which tab to display
function nextPrev(n) {

    let tabs = $('.tab');
    let validForm;
    // if user click on next button
    if (n === 1) {
        validForm = validateForm();
        let step = $(".step").get(currentTab);
        if (validForm) {
            $(step).addClass("finish");
        } else {
            $(step).removeClass("finish");
            // Exit the function if any field in the current tab is invalid:
            return;
        }
    }

    // Increase or decrease the current tab by 1:
    currentTab = currentTab + n;

    // if you have reached the end of the form... :
    if (currentTab >= tabs.length && validForm) {
        //...the form gets submitted:
        document.getElementById("internship-form").submit();
    } else {
        // Otherwise, display the correct tab:
        showTab(currentTab);
    }
}

// This function deals with validation of the form fields
function validateForm() {
    let valid = true;
    let tabs = document.getElementsByClassName("tab");
    let fields = $(tabs[currentTab]).find("input, select, textarea");
    console.log(fields);
    $(fields).each((index, field) => {
        // If a field is empty...

        if ($(field).val() === "" && $(field).prop('required')) {
            // add an "invalid" class to the field:
            $(field).addClass("invalid");
            // and set the current valid status to false:
            valid = false;
        } else {
            $(field).removeClass("invalid");
        }
    });
    return valid; // return the valid status
}


/*
function fixStepIndicator(n) {
    // This function removes the "active" class of all steps...
    let i, x = document.getElementsByClassName("step");
    for (i = 0; i < x.length; i++) {
        x[i].className = x[i].className.replace(" active", "");
    }
    //... and adds the "active" class to the current step:
    x[n].className += " active";
}*/
