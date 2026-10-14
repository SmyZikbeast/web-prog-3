import {addButton, getText, addText, getSelect} from './inputs.js';
import {drawPoint, clear, draw} from './canvas.js';

const form = document.getElementById('form')
const table = document.getElementById('result-table');
const tbody = document.getElementById('result-table-body');
const error = document.getElementById('error-field');
const canvas = document.getElementById('graph');
const radius = canvas.height/2 - 40;
const rect = canvas.getBoundingClientRect();
let x;
let y;
let r;
let selectedRow;

export function handleTable(){
    form.addEventListener('submit', (event) => {
        event.preventDefault();
        getText('y-text', updateY, -3, 3);
        getSelect('r-select', updateR);
        console.log("x = " + x + " y = " + y + " r = " + r);
        if (x == null){
            error.innerText = 'wrong x value';
        } else if (y == null){
            error.innerText = 'wrong y value';
        } else if (y == 'wrong length'){
            error.innerText = 'wrong y length';
        } else if (r == null || r == ""){
            error.innerText = 'wrong r value';
        } else {
            window.location.href = `controller?x=${x}&y=${y}&r=${r}`;
            error.innerText = '';
        }
    }
    )
    table.addEventListener('click', (event) => {
        let n = event.target.closest('td').closest('tr').rowIndex;
        let tr = table.rows[n];
        if (tr) {
            selectedRow = tr;
        }
    })
    handleCanvas();
}

function handleCanvas(){
    canvas.addEventListener('click', (event) => {
        getSelect('r-select', updateR);
        if (r == null || r == ""){
            error.innerText = 'невозможно определить координаты';
        }
        else {
            error.innerText = '';
            let clientX = event.clientX - rect.left;
            let clientY = event.clientY - rect.top;
            const centerX = 400;
            const centerY = 400;
            x = parseFloat(((clientX - centerX) / radius * r).toFixed(3));
            y = parseFloat(((clientY - centerY) / radius * r).toFixed(3));
            window.location.href = `controller?x=${x}&y=${-y}&r=${r}`;
        }
    })
}

function drawPointRow(row, color){
    drawPoint(row.cells[1].innerText, row.cells[2].innerText, row.cells[3].innerText, color);
}

function drawPoints(){
    clear();
    draw();
    if (selectedRow){
        drawPointRow(selectedRow, 'green');
    }
    let last = getLast();
    if(last){
        drawPointRow(last, 'red');
    }
}

function getLast(){
    let firstRow = document.querySelector('#result-table-body tr');
    if (!firstRow){
        return null
    }
    return firstRow;
}

let timezone = new Date().getTimezoneOffset();
function checkTimezone(){
    let newTimezone = new Date().getTimezoneOffset();
    if (timezone !== newTimezone){
        console.log('timezone changed, updating table');
        timezone = newTimezone;
        updateTable();
    }
    drawPoints();
}

function updateX(value){
    x = value;
}

function updateY(value){
    y = value;
}

function updateR(value){
    r = value;
}

addButton('.x-button', updateX);
addText('y-text', -3, 3);
setInterval(checkTimezone, 500);
