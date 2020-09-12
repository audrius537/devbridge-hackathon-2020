/// <reference types="cypress" />
let calculate
let i
let number1
let number2
let number3
let string

context('Solve Escape Room', () => {
    it(('Visit page and move several postcards, drag stars'), () => {
        cy.visit('https://www.enchambered.com/puzzles/escape-sacramento-landmark-puzzle-capital/game/')
        cy.get('.intro').click()
        cy.get('#postcard3').click()
        cy.get('#postcard4').click()

        for (i = 1; i < 4; i++) {
            cy.get('#star' + i).drag('#holes', { force: true })
        }

    })

it(('Calculate code and enter numbers to open the safe'), () => {
        cy.get('#starhint').drag('#numCard', { force: true })
        cy.get('#postcard1').click()

        calculate = 1850 - 1400
        string = calculate.toString();

        number1 = string.substring(0,1);
        number2 = string.substring(1,2);
        number3 = string.substring(2,3);

        for (i = 0; i < number1 ; i++) {
            cy.get('.dial1').click();
        }

        for (i = 0; i < number2; i++) {
            cy.get('.dial2').click();
        }

        for (i = 0; i < number3; i++) {
            cy.get('.dial3').click();
        }

    })
    it(('Enter Capitals word and open door for key'), () => {
        cy.get('#postcard2').click()

        cy.wait(1000)
        cy.get('#tvdial').drag('#tv')

        cy.get('.key3').click()
        cy.get('.key1').click()
        cy.get('.key9').click()
        cy.get('.key6').click()
        cy.get('.key2').click()
        cy.get('.key7').click()
        cy.get('.key8').click()
        cy.wait(1000)
        cy.get('#last_key').drag('.capital_secret', { force: true })
    })

    it(('Take screenshot of success'), () => {
        cy.wait(1000)
        cy.screenshot('escaped')
    })
})