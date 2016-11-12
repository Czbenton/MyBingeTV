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
                ev.preventDefault();
                const hider = document.querySelector("#error-alert");

                hider.classList.remove("cancel");
                hider.classList.add("show-me");
                const icon = document.querySelector(".icon");
                icon.addEventListener('click', function(ev)  {
                    ev.preventDefault()
                    const swoosh = document.querySelector("#error-alert");
                swoosh.classList.add("cancel");
            });
            }else {
                var x = document.querySelector('.fa')
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