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
            }else {
                var x = document.querySelector('.fa-spinner')
                x.style.visibility="visible";
            }
        });
    }

    var searchForm2 = document.querySelector('.search-formSmall');
    var searchFormInput2 = document.querySelector('.searchInputSmall');
    if (searchForm2) {
        searchForm2.addEventListener('submit', function (ev) {
            if (!searchFormInput2 || searchFormInput2.value === '') {
                alert('You must fill in the form');
                ev.preventDefault();
            }
        });
    }

})();