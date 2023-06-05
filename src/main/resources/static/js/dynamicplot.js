// Отримання даних з об'єкту моделі у Spring Boot
/* вставте код для отримання даних з об'єкту моделі */;
function startup(xTime,t,h,p){
  let time = xTime;
let temperature = t;
let humidity = h;
let pressure = p;

// Побудова графіка
let temperatureContext = document.getElementById('temperatureChart').getContext('2d');
let temperatureChart = new Chart(temperatureContext, {
    type: 'line',
    data: {
        labels: time,
        datasets: [{
            label: 'Температура',
            data: temperature,
            backgroundColor: 'rgba(200, 180, 190, 0.5)',
            borderColor: 'rgba(180, 20, 20, 1)',
            borderWidth: 1
        }]
    },
    options: {
        responsive: true,
        scales: {
            x: {
                display: true,
                title: {
                    display: true,
                    text: 'Час'
                },
                ticks: {
                    callback: function(val, index) {
                        // Hide every 2nd tick label
                        return index % 5 === 0 ? this.getLabelForValue(val) : '';
                    }
                }
            },
            y: {
                display: true,
                title: {
                    display: true,
                    text: 'Температура'
                },
                suggestedMin: 0,
                suggestedMax: 50
            }
        },
        fill: true,
        plugins:{
            legend:{
                position:'right'
            }
        }
    }
});
//humidity
let humidityContext = document.getElementById('humidityChart').getContext('2d');
let humidityChart = new Chart(humidityContext, {
    type: 'line',
    data: {
        labels: time,
        datasets: [{
            label: 'Вологість',
            data: humidity,
            backgroundColor: 'rgba(200, 180, 190, 0.5)',
            borderColor: 'rgba(20, 20, 200, 1)',
            borderWidth: 1
        }]
    },
    options: {
        responsive: true,
        scales: {
            x: {
                display: true,
                title: {
                    display: true,
                    text: 'Час'
                },
                ticks: {
                    callback: function(val, index) {
                        // Hide every 2nd tick label
                        return index % 5 === 0 ? this.getLabelForValue(val) : '';
                    }
                }
            },
            y: {
                display: true,
                title: {
                    display: true,
                    text: 'Вологість'
                },
                suggestedMin: 0,
                suggestedMax: 100
            }
        },
        fill: true,
        plugins:{
            legend:{
                position:'right'
            }
        }
    }
});


//pressure
let pressureContext = document.getElementById('pressureChart').getContext('2d');
let pressureChart = new Chart(pressureContext, {
    type: 'line',
    data: {
        labels: time,
        datasets: [{
            label: 'Тиск',
            data: pressure,
            backgroundColor: 'rgba(200, 180, 190, 0.5)',
            borderColor: 'rgba(20, 200, 200, 1)',
            borderWidth: 1
        }]
    },
    options: {
        responsive: true,
        scales: {
            x: {
                display: true,
                title: {
                    display: true,
                    text: 'Час'
                },
                ticks: {
                    callback: function(val, index) {
                        // Hide every 2nd tick label
                        return index % 5 === 0 ? this.getLabelForValue(val) : '';
                    }
                }
            },
            y: {
                display: true,
                title: {
                    display: true,
                    text: 'Тиск'
                }
            }
        },
        fill: true,
        plugins:{
            legend:{
                position:'right'
            }
        }
    }
});


setInterval(async () => {
    responce = await fetch('/climate/getlast');
    data = await responce.json()
    // TODO: PARSE DATA TO CHART
    temperatureChart.data.labels.push(data.registratiomTime);
    temperatureChart.data.labels.shift();//var labels = 
    //console.log(labels);
    //temperatureChart.data.labels = labels;
    temperatureChart.data.datasets[0].data.push(data.temperature)
    temperatureChart.data.datasets[0].data.shift();//temperatureChart.data.datasets[0].data = 
    
    //humidityChart.data.labels = labels;
    humidityChart.data.datasets[0].data.push(data.humidity);
    humidityChart.data.datasets[0].data.shift();//humidityChart.data.datasets[0].data = 
    
    //pressureChart.data.labels = labels;
    pressureChart.data.datasets[0].data.push(data.pressure);
    pressureChart.data.datasets[0].data.shift();//pressureChart.data.datasets[0].data = 


    temperatureChart.update();
    humidityChart.update();
    pressureChart.update();
}, 60*1000);
}