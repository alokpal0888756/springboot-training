// to declare variables - let, const and var (avoid using this)
let counter = 0;

function increment(){
    counter++;
    displayCounterToUi()
}
function decrement(){
    counter--;
    displayCounterToUi()
}

function displayCounterToUi(){
    let ele = document.getElementById("a");
    // to add the content we will use innerHTML
    ele.innerHTML = 'Counter = '+ counter;
}