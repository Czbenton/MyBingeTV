(function() {
    var moreButtons = document.querySelectorAll('.open-truncate');

    Array.from(moreButtons).forEach(function(button) {
        button.addEventListener('click', function() {
            button.parentElement.querySelector('.truncate').style.whiteSpace = 'normal';
        });
    });
})();