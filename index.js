const report = require('multiple-cucumber-html-reporter');

report.generate({
	jsonDir: './test/report/',
	reportPath: './test/report/',
	metadata:{
        browser: {
            name: 'chrome',
            version: '104.0.5112.81 (Build oficial) (64 bits)'
        },
        device: 'Local test machine',
        platform: {
            name: 'Windows',
            version: '11'
        }
    },
    customData: {
        title: 'Run info',
        data: [
            {label: 'Project', value: 'Custom project'},
            {label: 'Release', value: '1.2.3'},
            {label: 'Cycle', value: 'B11221.34321'},
            {label: 'Execution Start Time', value: '8/8/2022 - 19:00hs'},
            {label: 'Execution End Time', value: '8/8/2022 - 19:05hs'}
        ]
    }
});