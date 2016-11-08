(function() {
    var moreButtons = document.querySelectorAll('.open-truncate');

    Array.from(moreButtons).forEach(function(button) {
        button.addEventListener('click', function() {
            if (button.parentElement.querySelector('.truncate').style.whiteSpace == 'nowrap') {
                button.parentElement.querySelector('.truncate').style.whiteSpace = 'normal';
                button.innerText = 'Show Less';
            } else {
                button.parentElement.querySelector('.truncate').style.whiteSpace = 'nowrap';
                button.innerText = 'Show More';
            }
        });
    });
})();