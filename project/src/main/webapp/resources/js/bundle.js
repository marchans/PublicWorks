function AdminPage(el) {
    this.el = el;
    this.exitEl = document.querySelector('.navbar--exit');
    this.registerButtonEl = this.el.querySelector('#register');
    this.listButtonEl = this.el.querySelector('#list');
    this.requestButtonEl = this.el.querySelector('#request');
    this.regFormEl = this.el.querySelector('.worker-registration');
    this.workListEl = this.el.querySelector('.worker-list');
    this.requestListEl = this.el.querySelector('.requests');
    this.workerEdit = this.workListEl.querySelectorAll('.worker-edit');
    this.initEventListeners();
}

AdminPage.prototype.removeAll = function () {
    this.workListEl.classList.add('disp-none');
    this.requestListEl.classList.add('disp-none');
    this.regFormEl.classList.add('disp-none');
};

AdminPage.prototype.initEventListeners = function() {
    var self = this;

    this.exitEl.addEventListener('click',function (e) {
        e.preventDefault();
        document.querySelector('#logoutForm').submit();
    });

    this.registerButtonEl.addEventListener('click', function () {
        self.removeAll();
        self.regFormEl.classList.remove('disp-none');
    });

    this.listButtonEl.addEventListener('click', function () {
        self.removeAll();

        var xhr = new XMLHttpRequest();
        xhr.open('GET', '/getWorkersList', false);

        xhr.onreadystatechange = function() {
            if (xhr.readyState != 4) return;
            if (xhr.status != 200) {
                alert("s");
            } else {
                alert(xhr.responseText);
            }
        };

        xhr.send();

        self.workListEl.classList.remove('disp-none');
    });

    this.requestButtonEl.addEventListener('click', function () {
        self.removeAll();

        var xhr = new XMLHttpRequest();
        xhr.open('GET', '/getRequestsList', false);

        xhr.onreadystatechange = function() {
            if (xhr.readyState != 4) return;
            if (xhr.status != 200) {
                alert("s");
            } else {
                alert(xhr.responseText);
            }
        };

        xhr.send();

        self.requestListEl.classList.remove('disp-none');
    });


    // Register worker js
    this.regFormEl.addEventListener('submit', function (evt) {
        evt.preventDefault();
        var xhr = new XMLHttpRequest();
        xhr.open('POST', '/addWorker', true);
        xhr.setRequestHeader("Content-Type", "application/json");

        xhr.onreadystatechange = function() {
            if (xhr.readyState != 4) return;
            if (xhr.status != 200) {
                // alert(xhr.status + ': ' + xhr.statusText);
            } else {
                alert(xhr.responseText);
            }
        };
        var formData = new FormData(self.regFormEl);
        console.log(formData);
        xhr.send(JSON.stringify({name:"John Rambo", time:"2pm"}));
    });

    // Edit worker js
    this.workerEdit.forEach(function (item) {
        var label = item.querySelectorAll('.worker-registration__label');
        var saveBut = item.querySelector('.worker-edit__save');
        label.forEach(function (i) {
            var text = i.querySelector('.worker-registration__title');
            var input = i.querySelector('.worker-registration__input');
            text.addEventListener('click', function () {
                text.classList.add('disp-none');
                input.classList.remove('disp-none');
                saveBut.classList.remove('disp-none');
                console.log(saveBut);
            });

            input.addEventListener('blur', function () {
                text.classList.remove('disp-none');
                input.classList.add('disp-none');
                if(input.value !== '') text.textContent = input.value;
            });

        });

        saveBut.addEventListener('click', function () {
            var name = item.querySelector('.w-name').textContent;
            var surname = item.querySelector('.w-surname').textContent;
            var address = item.querySelector('.w-address').textContent;
            var tel = item.querySelector('.w-tel').textContent;
            var login = item.querySelector('.w-login').textContent;
            var pass = item.querySelector('.w-pass').textContent;

            var xhr = new XMLHttpRequest();
            xhr.open('UPDATE', '/updateWorker', true);
            xhr.setRequestHeader("Content-Type", "application/json");

            xhr.onreadystatechange = function() {
                if (xhr.readyState != 4) return;
                if (xhr.status != 200) {
                    alert(JSON.stringify({name:name, surname:surname, address:address, tel:tel, login:login, pass:pass}));
                } else {
                    alert(xhr.responseText);
                    saveBut.classList.add('disp-none');
                }
            };

            xhr.send(JSON.stringify({name:name, surname:surname, address:address, tel:tel, login:login, pass:pass}));
        });
    });

    //Requests for registration js
    this.requestListEl.querySelectorAll('.request__item').forEach(function (el) {
        el.querySelector('.but-accept').addEventListener('click',function () {
            var xhr = new XMLHttpRequest();
            xhr.open('GET', '/registration-accept?id', true);

            xhr.onreadystatechange = function() {
                if (xhr.readyState != 4) return;
                if (xhr.status != 200) {
                    alert("s");
                } else {
                    alert(xhr.responseText);
                }
            };

            xhr.send();
        });

        el.querySelector('.but-decline').addEventListener('click',function () {
            var xhr = new XMLHttpRequest();
            xhr.open('GET', '/registration-decline?id', true);

            xhr.onreadystatechange = function() {
                if (xhr.readyState != 4) return;
                if (xhr.status != 200) {
                    alert("s");
                } else {
                    alert(xhr.responseText);
                }
            };

            xhr.send();
        });
    });

};

function WorkerPage(el) {
    this.el = el;
    this.requestsBut = this.el.querySelector('.requests-but');
    this.initEventListeners();
}

WorkerPage.prototype.initEventListeners = function() {
    var self = this;
    this.requestsBut.addEventListener('click', function () {
        var xhr = new XMLHttpRequest();
        xhr.open('GET', '/peopleRequests', false);

        xhr.onreadystatechange = function() {
            if (xhr.readyState != 4) return;
            if (xhr.status != 200) {
                alert("s");
            } else {
                alert(xhr.responseText);
            }
        };

        xhr.send();

        self.el.querySelector('.requests').classList.remove('disp-none');
    });


    self.el.querySelectorAll('.request__item').forEach(function (el) {
        var acceptBut = el.querySelector('.button--accept');
        var doneBut = el.querySelector('.button--done');
        var declineBut = el.querySelector('.button--decline');

        acceptBut.addEventListener('click', function () {
            var xhr = new XMLHttpRequest();
            xhr.open('GET', '/request-accept?id', true);

            xhr.onreadystatechange = function() {
                if (xhr.readyState != 4) return;
                if (xhr.status != 200) {
                    alert("s");
                } else {
                    alert();
                }
            };

            xhr.send();
        });


        declineBut.addEventListener('click', function () {
            var xhr = new XMLHttpRequest();
            xhr.open('GET', '/request-decline?id', true);

            xhr.onreadystatechange = function() {
                if (xhr.readyState != 4) return;
                if (xhr.status != 200) {
                    alert("s");
                } else {
                    alert();
                }
            };

            xhr.send();
        });


        doneBut.addEventListener('click', function () {
            var xhr = new XMLHttpRequest();
            xhr.open('GET', '/request-done?id', true);

            xhr.onreadystatechange = function() {
                if (xhr.readyState != 4) return;
                if (xhr.status != 200) {
                    alert("s");
                } else {
                    acceptBut.classList.add('disp-none');
                }
            };

            xhr.send();
        });
    });

};

function UserPage(el) {
    this.el = el;
    this.makePaymentButtonEl = this.el.querySelector('.make-payment-js');
    this.paymentFormEl = this.el.querySelector('.payment-form');
    this.submitPaymentButtonEl = this.el.querySelector('.payment-form__submit');
    this.paymentListButtonEl = this.el.querySelector('.payment-list-js');
    this.paymentListEl = this.el.querySelector('.payment-list');
    this.makeDeclarationButtonEl = this.el.querySelector('.make-declaration-js');
    this.declarationListButtonEl = this.el.querySelector('.declaration-list-js');
    this.paymentFormEl = this.el.querySelector('.payment-form');
    this.paymentListEl = this.el.querySelector('.payment-list');
    this.declarationFormEl = this.el.querySelector('.declaration-form');
    this.declarationListEl = this.el.querySelector('.declaration-list');
    this.initEventListeners();
}

UserPage.prototype.removeAll = function () {
    this.paymentFormEl.classList.add('disp-none');
    this.paymentListEl.classList.add('disp-none');
    this.declarationFormEl.classList.add('disp-none');
    this.declarationListEl.classList.add('disp-none');
};

UserPage.prototype.initEventListeners = function() {
    var self = this;
    this.makeDeclarationButtonEl.addEventListener('click', function () {
        self.removeAll();
        self.declarationFormEl.classList.remove('disp-none');
    })
    this.makePaymentButtonEl.addEventListener('click',function () {
        self.removeAll();
        self.paymentFormEl.classList.remove('disp-none');
    })

    this.declarationListButtonEl.addEventListener('click', function () {
        self.removeAll();

        var xhr = new XMLHttpRequest();
        xhr.open('GET', '/getDeclarationsList', true);

        xhr.onreadystatechange = function() {
            if (xhr.readyState != 4) return;
            if (xhr.status != 200) {
                alert("Declaration List!");
            } else {
                alert(xhr.responseText);
            }
        };

        xhr.send();

        self.declarationListEl.classList.remove('disp-none');
    });

    this.declarationFormEl.addEventListener('submit', function (evt) {
        evt.preventDefault();
        var xhr = new XMLHttpRequest();
        xhr.open('POST', '/makeDeclaration', true);
        xhr.setRequestHeader("Content-Type", "application/json");

        xhr.onreadystatechange = function () {
            if (xhr.readyState != 4) return;
            if (xhr.status != 200) {
                // alert(xhr.status + ': ' + xhr.statusText);
            } else {
                alert(xhr.responseText);
            }
        };
        var formData = new FormData(self.declarationFormEl);
        console.log(formData);
        xhr.send(JSON.stringify({ id: "2", service: "trash", description: "My water broke yesterday!" }));
    });

    this.paymentFormEl.addEventListener('submit', function (evt) {
        evt.preventDefault();
        var xhr = new XMLHttpRequest();
        xhr.open('POST', '/makePayment', true);
        xhr.setRequestHeader("Content-Type", "application/json");

        xhr.onreadystatechange = function () {
            if (xhr.readyState != 4) return;
            if (xhr.status != 200) {
                // alert(xhr.status + ': ' + xhr.statusText);
            } else {
                alert(xhr.responseText);
            }
        };
        var formData = new FormData(self.paymentFormEl);
        console.log(formData);
        xhr.send(JSON.stringify({ id: "2", service: "trash", total: 540 }));
    });

    this.paymentListButtonEl.addEventListener('click', function () {
        self.removeAll();

        var xhr = new XMLHttpRequest();
        xhr.open('GET', '/getPaymentsList', true);

        xhr.onreadystatechange = function() {
            if (xhr.readyState != 4) return;
            if (xhr.status != 200) {
                alert("Payment List");
            } else {
                alert(xhr.responseText);
            }
        };

        xhr.send();

        self.paymentListEl.classList.remove('disp-none');
    });
};

function initUserPage() {
    var mainEl = document.querySelector('.main');
    new UserPage(mainEl);
}

function initAdminPage() {
    var mainEl = document.querySelector('.main');
    new AdminPage(mainEl);
}

function initWorkerPage() {
    var mainEl = document.querySelector('.main');
    new WorkerPage(mainEl);
}

if(document.querySelector('body').dataset.page === 'admin') {
    initAdminPage();
}
else if(document.querySelector('body').dataset.page === 'worker') {
    initWorkerPage();
}
else if(document.querySelector('body').dataset.page === 'user'){
    initUserPage();
}