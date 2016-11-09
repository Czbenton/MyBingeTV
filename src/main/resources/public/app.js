(function () {
    var moreButtons = document.querySelectorAll('.open-truncate');

    Array.from(moreButtons).forEach(function (button) {
        button.addEventListener('click', function () {
            if (button.parentElement.querySelector('.truncate').style.whiteSpace == 'nowrap') {
                button.parentElement.querySelector('.truncate').style.whiteSpace = 'normal';
                button.innerText = 'Show Less';
            } else {
                button.parentElement.querySelector('.truncate').style.whiteSpace = 'nowrap';
                button.innerText = 'Show More';
            }
        });
    });

    var searchForm = document.querySelector('.search-form');
    var searchFormInput = document.querySelector('.searchInput');
    if (searchForm) {
        searchForm.addEventListener('submit', function (ev) {
            if (!searchFormInput || searchFormInput.value === '') {
                alert('You must fill in the form');
                ev.preventDefault();
            }
        });
    }

})();