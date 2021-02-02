/**

 Table home JS
 handle modification in the table

 **/

let table;
let dataFormCurrentSaved;
// doc ready
$(() => {
// Initialisation
    table = $('#interns-table').DataTable({
        paging: true,
        pageLength: 5,
        order: [],
        columnDefs: [
            {"targets": [0, 4, 5, 6, 7, 8, 9, 10, 11, 14], "searchable": false, "orderable": false, "visible": true},
        ]
    });
    // init current data saved in database
    dataFormCurrentSaved = getFormData();
    handleRow();
    handleForm();
    handleDeleteInternship();
    $("#detail-btn").prop('disabled', true);

});

function handleRow() {
    let detailBtn = $('#detail-btn');
    detailBtn.addClass('disabled');
    $(document).on('click', 'input[type=radio]', (e) => {
        detailBtn.removeClass('disabled');
        let id = $(e.target).data('internshipId');
        let url = detailBtn.attr('href').split('?id=')[0];
        detailBtn.attr('href', `${url}?id=${id}`);
        $("#detail-btn").prop('disabled', false);
    });
}

function handleDeleteInternship() {
    $(document).on('click', '.btn-delete-internship', (e) => {
        let path = $('#contextPathHolder').data('contextPath') + "/?id=" + $(e.currentTarget).data('internshipId');
        let row = $(e.currentTarget).closest('tr');
        $(row).children('td')
            .css({backgroundColor: 'red', color: 'white'});
        setTimeout(function () {
                $(row)
                    .children()
                    .slideUp(300, function () { /*$(row).remove();*/
                    });
            }, 350
        );
        $.ajax({
            url: path,
            method: 'delete',
            success: (e) => {
                console.log('internship delete');
                addAlertMessage('internship delete', 'success');
                let row = $(e.currentTarget).closest('tr');
                $(row).children('td')
                    .css({backgroundColor: "red", color: "white"});
                setTimeout(function () {
                        $(row)
                            .children()
                            .slideUp(300, function () {
                                $(row).remove();
                            });
                    }, 350
                );
            },
            error: (e) => {
                console.log('internship error');
                addAlertMessage('internship error', 'danger');
            }
        })
    });
}

/**
 * Handle the interns modifications
 */
function handleForm() {

    $("#interns-form").on('submit', (e) => {
        e.preventDefault();
        // get only data that will has changed
        let dataFormWillChanged = getFormData().filter((f, index) => JSON.stringify(dataFormCurrentSaved[index].fields) !== JSON.stringify(f.fields));
        console.log(dataFormWillChanged);
        // send data
        updateTableAjax(dataFormWillChanged);
    });
}

/**
 *
 */
function getFormData() {
    let rowsData = [];
    // spinner
    for (let i = 0; i < table.rows().nodes().length; i++) {

        let row = $(table.rows().nodes()[i]);
        let internId = parseInt($(row).data('internId'));
        let studentId = parseInt($(row).data('studentId'));
        let fields = [];
        // get only data from input text and input checkbox
        fields = $(row).find("input[type=text],input[type=checkbox]").serializeArray();
        //console.log(fields);
        // add also unchecked checkbox
        $(row).find("input[type=checkbox]:not(:checked)").each(function () {
            fields.push({name: this.name, value: "off"});
        });

        let data = {
            "id": internId,
            "studentId": studentId,
            "fields": fields
        }
        rowsData.push(data);
    }
    return rowsData;
}

/**
 * send a ajax request to update modification
 * @param data
 */
function updateTableAjax(data) {

    let path = $('#contextPathHolder').data('contextPath') + "/";

    let jsonData = {
        "data": data
    }
    $.ajax({
        url: path,
        method: 'post',
        data: {
            "data": JSON.stringify(jsonData)
        },
        beforeSend: () => {
            $('#interns-form button[type=submit]').prop('disabled', true);
        },
        success: (e) => {
            console.log(e);
            // update current data saved
            dataFormCurrentSaved = getFormData();
            addAlertMessage(e, 'success');
            setTimeout(() => $('#interns-form button[type=submit]').prop('disabled', false), 2000);

        },
        error: (e) => {
            console.log('error', e);
            addAlertMessage(e, 'danger');
            setTimeout(() => $('#interns-form button[type=submit]').prop('disabled', false), 2000);
        },

    });
}


function addAlertMessage(message, type) {
    let messages = $('.alerts-box .messages');
    messages.empty();
    messages.append(createAlertMessage(message, type)).hide().fadeIn(500);

    setTimeout(() => {
        $('.messages .alert').fadeOut(500, function () {
            $(this).remove();
        });
    }, 2000);
}


/**
 * Create a success alert box
 * @param message
 * @param type
 * @returns {string}
 */
function createAlertMessage(message, type) {
    return `
        <div class="alert alert-${type}" role="alert">
            ${message}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    `;
}

function deleteRow(e) {
    let row = $(e.currentTarget).closest('tr');
    $(row).children('td')
        .css({backgroundColor: "red", color: "white"});
    setTimeout(function () {
            $(row)
                .children()
                .slideUp(300, function () { /*$(row).remove();*/
                });
        }, 350
    );
}